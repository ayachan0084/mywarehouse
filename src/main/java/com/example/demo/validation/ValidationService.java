package com.example.demo.validation;

import com.example.demo.dto.ProductUpscaleDto;

public interface ValidationService {

    boolean isValid(ProductUpscaleDto product);
}
