package com.example.demo.mapper;

import com.example.demo.dto.ProductResponseDto;
import com.example.demo.dto.ProductUpscaleDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    Product toModel(ProductEntity entity);

    Product toModel(ProductUpscaleDto dto);

    ProductEntity toEntity(Product model);

    ProductResponseDto toDto(Product model);
}
