package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.CustomerProfile;
import lombok.Getter;

@Getter
public class CustomerProfileResponseDto {
    private String nickname;
    private boolean isImageExist;

    public CustomerProfileResponseDto(CustomerProfile customerProfile) {
        this.nickname = customerProfile.getNickname();
        this.isImageExist = customerProfile.isImageExist();
    }
}
