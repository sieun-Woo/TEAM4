package com.sparta.shoppingmall.dto;


import lombok.Getter;

@Getter
public class SignInResponseDto {
    private final String statusCode;
    private final String message;

    public SignInResponseDto(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
