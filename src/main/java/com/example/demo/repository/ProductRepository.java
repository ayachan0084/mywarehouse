package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductRepository {

    List<ProductEntity> findAll(int limit, int offset);

    ProductEntity save(Product product);
}