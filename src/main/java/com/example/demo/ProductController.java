package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    //Аннотация гласит - отправление новых данных
    @PostMapping
    //Из класса Продукт используется метод saveProduct
    //Этот метод использует ан-ию реквест бади, чтобы создать новый запрос
    //Запрос означает, что когда мы отправляем новые данные - ан-ия превращает формат JSON в объект Product
    //А затем возвращает сохраненный продукт в сервис
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);

    }

}




