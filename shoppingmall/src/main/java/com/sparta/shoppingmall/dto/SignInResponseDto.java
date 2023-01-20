package com.sparta.shoppingmall.dto;

public class SignInResponseDto {
    private final String statusCode;
    private final String message;

    public SignInResponseDto(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
