package com.sparta.shoppingmall.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderRequestDto {

    private String requireComment;
    private String addressee;
    private String address;
    private String phone;
}
