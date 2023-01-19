package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.dto.ProductResponseDto;
import com.sparta.shoppingmall.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByUserOrderByIdDesc(ProductResponseDto product, Pageable pageable);

}
