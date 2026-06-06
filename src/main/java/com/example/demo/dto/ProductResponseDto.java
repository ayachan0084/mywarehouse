package com.example.demo.dto;

public record ProductResponseDto(
        Long id,
        String name,
        Double price,
        Integer quantity
) {
}
