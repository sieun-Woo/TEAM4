package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.SellerProfileResponseDto;
import com.sparta.shoppingmall.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seller/")
public class SellerProfileController {

    private final RegistrationService registrationService;

    // 판매자 프로필 조회만
    @GetMapping("/profile")
    public SellerProfileResponseDto readSellerProfile() {
        return registrationService.readMySellerProfile();
    }


}
