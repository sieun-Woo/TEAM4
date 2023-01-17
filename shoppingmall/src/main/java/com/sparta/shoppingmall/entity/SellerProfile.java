package com.sparta.shoppingmall.entity;

import com.sparta.shoppingmall.dto.SellerProfileRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class SellerProfile extends Timestamped{
    @Id
    private Long id;

    @Column
    private String nickname;

    @Column
    private String introduce;

    @Column
    private String category;

    public SellerProfile (SellerProfileRequestDto sellerProfileRequestDto) {
        this.nickname = sellerProfileRequestDto.getNickname();
        this.introduce = sellerProfileRequestDto.getIntroduce();
        this.category = sellerProfileRequestDto.getCategory();
    }
}
