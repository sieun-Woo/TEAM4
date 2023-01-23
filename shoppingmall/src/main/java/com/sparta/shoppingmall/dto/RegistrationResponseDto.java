package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.Registration;
import com.sparta.shoppingmall.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class RegistrationResponseDto {

    private String userName;
    private Long id;
    private String nickName;
    private String image;
    private String intro;

    public RegistrationResponseDto(Registration registration) {
        this.userName = registration.getUserName();
        this.id = registration.getId();
        this.nickName = registration.getNickName();
        this.image = registration.getImage();
        this.intro = registration.getIntro();
    }

    public RegistrationResponseDto(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
        this.nickName = user.getNickName();
        this.image = user.getImage();
        this.intro = user.getIntro();
    }

    public static RegistrationResponseDto add(Registration registration){
        return new RegistrationResponseDto(registration);
    }
}
