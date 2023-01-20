package com.sparta.shoppingmall.exception;

public class CustomException extends RuntimeException {
    private final int status;
    private final String message;

    public CustomException(ErrorCode errorCode){
        this.status=errorCode.getStatus().value();
        this.message=errorCode.getMessage();

    }
}
