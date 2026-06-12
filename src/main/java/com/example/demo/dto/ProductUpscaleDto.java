package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductUpscaleDto(
        @NotBlank
        String name,
        BigDecimal price,
        @Max(value = 100)
        Integer quantity
) {
}
