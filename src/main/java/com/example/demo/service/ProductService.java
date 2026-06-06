package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(int limit, int offset);

    Product saveProduct(Product product);
}