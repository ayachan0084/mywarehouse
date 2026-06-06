package com.example.demo.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record Product(
        Long id,
        String name,
        BigDecimal price,
        Integer quantity
) {
}
