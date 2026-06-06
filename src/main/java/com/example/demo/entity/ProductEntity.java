package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductEntity {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}