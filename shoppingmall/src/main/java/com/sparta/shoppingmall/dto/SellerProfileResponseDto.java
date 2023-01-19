package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.SellerProfile;

import java.time.LocalDateTime;

public class SellerProfileResponseDto {

    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;

    private String nickname;

    public SellerProfileResponseDto(SellerProfile sellerProfile) {
        this.createAt = sellerProfile.getCreateAt();
        this.modifiedAt = sellerProfile.getModifiedAt();
        this.nickname = sellerProfile.getNickname();
    }
}
