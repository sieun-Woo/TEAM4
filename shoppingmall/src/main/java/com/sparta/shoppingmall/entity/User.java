package com.sparta.shoppingmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleEnum role;

    private String nickName = "";
    private String image= "";
    private String intro= "";


    public User(String username, String password, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.nickName = getNickName();
        this.image = getImage();
        this.intro = getIntro();
    }

    public void sellerToCustomer() {
        this.role = UserRoleEnum.CUSTOMER;
        this.role = UserRoleEnum.SELLER;
        this.nickName = getNickName();
        this.intro = getIntro();
        this.image = getImage();
    }

    public void customerToSeller(Registration registration) {
        this.role = UserRoleEnum.SELLER;
        this.nickName = registration.getNickName();
        this.intro = registration.getIntro();
        this.image = registration.getImage();
    }
}


