package com.example.demo.controller;

import com.example.demo.dto.ProductResponseDto;
import com.example.demo.dto.ProductUpscaleDto;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper mapper;
    private final ProductService productService;
    private final ValidationService validationService;


    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProducts(
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "offset", defaultValue = "0") int offset
    ) {
        List<ProductResponseDto> products = productService.getAllProducts(limit, offset)
                .stream()
                .map(mapper::toDto)
                .toList();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductUpscaleDto product) {
        if (!validationService.isValid(product)) {
            return ResponseEntity.badRequest().build();
        }
        Product model = productService.saveProduct(mapper.toModel(product));
        ProductResponseDto dto = mapper.toDto(model);
        return ResponseEntity.ok(dto);
    }

}




