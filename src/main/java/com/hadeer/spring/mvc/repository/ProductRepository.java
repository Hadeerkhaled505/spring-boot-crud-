package com.hadeer.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hadeer.spring.mvc.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
Product findByName(String name);
}
