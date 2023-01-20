package com.sparta.shoppingmall.exception;

public class IdNotFoundException extends CustomException {
    public IdNotFoundException(){
        super(ErrorCode.ID_NOT_FOUND);
    }

}
