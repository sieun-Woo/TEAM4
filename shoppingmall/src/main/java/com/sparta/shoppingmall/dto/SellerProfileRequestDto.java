package com.sparta.shoppingmall.dto;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class SellerProfileRequestDto {

    @Column
    private String nickname;

    @Column
    private String introduce;

    @Column
    private String category;


}
