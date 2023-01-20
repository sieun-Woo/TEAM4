package com.sparta.shoppingmall.dto;

public class SignUpResponseDto {
    private final String statusCode;
    private final String message;

    public SignUpResponseDto(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
