//Это файловый путь к нашему проекту, пишем его первым делом
//Тк Спринг читает сверху вниз и ищет нужный файл по этому package
package com.example.demo;

//Здесь у меня хранятся все импорты, связанные с аннотациями.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//Главный класс продукт, чертеж по которым создаются мои объекты
//@Entity говорит спрингу что класс ниже должен создать таблицу в базе данных
//@Table(name = "products") тоже относится к таблице, говорит спрингу что мы хотим таблицу именно 'продуктов
@Entity
@Table(name = "products")
public class Product {
    //@Id - Аннотации нужные для генерации айди, рандомайзер в пределах типа long
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Long с большой буквы, тк это объект и он может быть null
    private Long id;
    private String name;
    private double price;
    private int quantity;

    //Пустой конструктор для БД, чтобы JPA не выдавала ошибку
    public Product(){

    }

    //Конструктор, главное чтобы порядок написания совпадал с порядком написания класса, иначе будет ошибка компиляции
    public Product(Long id, String name, double price, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

//Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}