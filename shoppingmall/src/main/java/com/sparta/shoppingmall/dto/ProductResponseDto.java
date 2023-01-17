package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.Product;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Getter
public class ProductResponseDto {

    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;

    private Long id;

    private String name;

    private int price;


    public ProductResponseDto(Product product) {
        this.createAt = product.getCreateAt();
        this.modifiedAt = product.getModifiedAt();
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
