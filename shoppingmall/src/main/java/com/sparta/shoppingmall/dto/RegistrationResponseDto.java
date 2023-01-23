package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.Registration;
import com.sparta.shoppingmall.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrationResponseDto {

    private Long id;
    private String nickName;
    private String image;
    private String intro;

    public RegistrationResponseDto(Registration registration) {
        this.id = registration.getId();
        this.nickName = registration.getNickName();
        this.image = registration.getImage();
        this.intro = registration.getIntro();
    }

    public RegistrationResponseDto(User user) {
        this.id = user.getId();
        this.nickName = user.getNickName();
        this.image = user.getImage();
        this.intro = user.getIntro();
    }

    public static RegistrationResponseDto add(Registration registration){
        return new RegistrationResponseDto(registration);
    }
}
