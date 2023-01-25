package com.sparta.shoppingmall.entity;

import com.sparta.shoppingmall.dto.CustomerRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    @Column
    private String nickname;
    @Column
    private boolean isImageExist;

    public Customer(CustomerRequestDto customerRequestDto, String username) {
        this.username = username;
        this.nickname = customerRequestDto.getNickname();
        this.isImageExist = customerRequestDto.getIsImageExist();
    }

    // 수정 기능 구현 시
    public void update(CustomerRequestDto customerRequestDto) {
        this.nickname =customerRequestDto.getNickname();
        this.isImageExist = customerRequestDto.getIsImageExist();
    }
}
