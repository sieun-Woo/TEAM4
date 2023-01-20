package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.Customer;
import lombok.Getter;

@Getter
public class CustomerProfileResponseDto {
    private String nickname;
    private boolean isImageExist;

    public CustomerProfileResponseDto(Customer customer) {
        this.nickname = customer.getNickname();
        this.isImageExist = customer.isImageExist();
    }

    public static CustomerProfileResponseDto add(Customer customer){
        return new CustomerProfileResponseDto(customer);
    }
}
