package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Аннотация помогает понять что ниже будет представлен репозиторий, для работы с БД
@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {
//Почему ProductRepository - это интерфейс?
//потому что спринг сам создает новые реализации внутри интерфейса, наследуя JPA
//JPA это набор правил, где внутри уже готовые методы
//типа findAll(), save(), deleteById()


}