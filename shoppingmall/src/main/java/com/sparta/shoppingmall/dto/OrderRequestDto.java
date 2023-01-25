package com.sparta.shoppingmall.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class OrderRequestDto {

    private List<Long> productList;
    private String requireComment;
    private String addressee;
    private String address;
    private String phone;
}
