package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.Customer;
import lombok.Getter;

@Getter
public class CustomerResponseDto {
    private String nickname;
    private boolean isImageExist;

    public CustomerResponseDto(Customer customer) {
        this.nickname = customer.getNickname();
        this.isImageExist = customer.isImageExist();
    }
}
