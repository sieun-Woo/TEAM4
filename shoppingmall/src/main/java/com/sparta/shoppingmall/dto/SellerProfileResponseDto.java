package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.Product;
import com.sparta.shoppingmall.entity.SellerProfile;

import java.time.LocalDateTime;

public class SellerProfileResponseDto {

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    private Long id;

    private String nickname;

    private String category;

    public SellerProfileResponseDto(SellerProfile sellerProfile) {
        this.createAt = sellerProfile.getCreateAt();
        this.modifiedAt = sellerProfile.getModifiedAt();
        this.id = sellerProfile.getId();
        this.nickname = sellerProfile.getNickname();
        this.category = sellerProfile.getCategory();
    }
}
