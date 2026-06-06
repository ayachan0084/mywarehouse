package com.example.demo.repository.impl;

import com.example.demo.entity.ProductEntity;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<ProductEntity> findAll(int limit, int offset) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("limit", limit)
                .addValue("offset", offset);

        return jdbcTemplate.query("""
                        SELECT id, name, price, quantity 
                        FROM products
                        ORDER BY id DESC -- Важно сортировать, чтобы пагинация была стабильной
                        LIMIT :limit 
                        OFFSET :offset
                        """,
                params,
                new DataClassRowMapper<>(ProductEntity.class)
        );
    }

    @Override
    public ProductEntity save(Product product) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", product.name())
                .addValue("price", product.price())
                .addValue("quantity", product.quantity());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update("""
                        INSERT INTO products (name, price, quantity)
                        VALUES (:name, :price, :quantity)
                        """,
                params,
                keyHolder,
                new String[]{"id"}
        );

        Long generatedId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return ProductEntity.builder()
                .id(generatedId)
                .name(product.name())
                .price(product.price())
                .quantity(product.quantity())
                .build();
    }
}
