package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

//Аннотация указывающая, что класс будет отвечать за логику, сервер
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;    //внедряет в класс Сервера класс Репозиторий

    public List<Product> getAllProducts() {
        return productRepository.findAll();   //Верни в метод getAllProducts все продукты что найдешь в Репозитории

    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);   //Верни в метод saveProduct(который должен быть типа Продукт)
                                                  //сохраненный продукт из Репозитория


    }



}