package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
