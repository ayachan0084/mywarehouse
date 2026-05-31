package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

//Аннотация над классом принимает http запрос браузера и возвращает json
@RestController
//Эта аннотация задает общий префикс для всех методов
@RequestMapping("/products")   //Все следующие методы будут начинаться с /products

public class ProductController {

    //Аннотация DI. Внедряет в класс Контроллер - Сервис
    @Autowired
    private ProductService productService;


    //Аннотация отвечает за get запросы, получение данных
    @GetMapping
    public List<Product> getProducts() {
                 //получая гет запрос /products, вызови метод getProducts
        return productService.getAllProducts();
    } //и пусть этот метод прошерстит весь Сервис и вернет все продукты
                                                  //в JSON

    //Аннотация гласит - отправление новых данных
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
        //Из класса Продукт используется метод saveProduct
        //Этот метод использует @RequestBody, чтобы создать новый запрос
        //Запрос означает, что когда мы отправляем новые данные - ан-ия превращает формат JSON в объект Product
        //А затем возвращает сохраненный продукт в сервис

    }

}




