package com.sparta.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInRequestDto {

    private String username;
    private String password;
}

