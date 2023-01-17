package com.sparta.shoppingmall.entity;

import com.sparta.shoppingmall.dto.CustomerProfileRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String nickname;
    @Column
    private boolean isImageExist;

    public CustomerProfile(CustomerProfileRequestDto customerProfileRequestDto) {
        this.nickname = customerProfileRequestDto.getNickname();
        this.isImageExist = customerProfileRequestDto.isImageExist();
    }
}
