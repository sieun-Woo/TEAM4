package com.sparta.shoppingmall.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponseDto {
    private int price;
    private LocalDateTime orderAt;
    private String requireComment;
    private String addressee;
    private String address;
    private String phone;
    private boolean orderStatus;

}
