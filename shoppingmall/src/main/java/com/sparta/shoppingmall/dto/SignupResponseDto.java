package com.sparta.shoppingmall.dto;

public class SignupResponseDto {
    private final String statusCode;
    private final String message;

    public SignupResponseDto(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
