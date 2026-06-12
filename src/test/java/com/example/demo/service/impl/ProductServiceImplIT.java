package com.example.demo.service.impl;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceImplIT extends BaseIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        // Очищаем таблицу перед каждым тестом (TRUNCATE очищает быстрее, чем DELETE)
        jdbcTemplate.execute("TRUNCATE TABLE products RESTART IDENTITY CASCADE");
    }

    @Test
    void saveProduct_ShouldInsertProductAndReturnEntityWithGeneratedId() {
        // Given
        Product inputProduct = Product.builder()
                .name("Laptop")
                .price(new BigDecimal("1200.50"))
                .quantity(5)
                .build();

        // When
        Product savedEntity = productService.saveProduct(inputProduct);

        // Then
        assertThat(savedEntity).isNotNull();
        assertThat(savedEntity.id()).isNotNull().isPositive();
        assertThat(savedEntity.name()).isEqualTo("Laptop");

        // Сравниваем BigDecimal через compareTo, так как у 1200.50 и 1200.500 разный scale
        assertThat(savedEntity.price()).isEqualByComparingTo(new BigDecimal("1200.50"));
        assertThat(savedEntity.quantity()).isEqualTo(5);
    }

    @Test
    void getAllProducts_ShouldReturnPaginatedAndSortedProducts() {
        // Given
        jdbcTemplate.execute("INSERT INTO products (name, price, quantity) VALUES ('Phone', 800.0, 10)");
        jdbcTemplate.execute("INSERT INTO products (name, price, quantity) VALUES ('Tablet', 400.0, 3)");
        jdbcTemplate.execute("INSERT INTO products (name, price, quantity) VALUES ('Monitor', 300.0, 7)");

        // When
        List<Product> result = productService.getAllProducts(2, 0);

        // Then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).name()).isEqualTo("Monitor");
        assertThat(result.get(1).name()).isEqualTo("Tablet");
    }
}