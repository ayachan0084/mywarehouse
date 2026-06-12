package com.example.demo.validation.impl;

import com.example.demo.dto.ProductUpscaleDto;
import com.example.demo.repository.ProductRepository;
import com.example.demo.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final ProductRepository productRepository;

    @Override
    public boolean isValid(ProductUpscaleDto product) {
        if (product.name().equals("invalid")) {
            return false;
        }
        return true;
    }
}
