package com.example.demo.service.impl;

import com.example.demo.entity.ProductEntity;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    @Override
    public List<Product> getAllProducts(int limit, int offset) {
        return repository.findAll(limit, offset)
                .stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity entity = repository.save(product);
        return mapper.toModel(entity);
    }
}
