package com.sparta.shoppingmall.entity;

import com.sparta.shoppingmall.dto.RegistrationRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String nickName;
    private String image;
    private String intro;

    public Registration(RegistrationRequestDto registrationRequestDto, Long id){
        this.userId = id;
        this.nickName = registrationRequestDto.getNickName();
        this.image = registrationRequestDto.getImage();
        this.intro = registrationRequestDto.getIntro();
    }
}
