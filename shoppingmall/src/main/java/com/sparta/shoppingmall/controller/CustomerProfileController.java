package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.CustomerProfileRequestDto;
import com.sparta.shoppingmall.dto.CustomerProfileResponseDto;
import com.sparta.shoppingmall.dto.SellerProfileRequestDto;
import com.sparta.shoppingmall.dto.SellerProfileResponseDto;
import com.sparta.shoppingmall.service.CustomerProfileService;
import com.sparta.shoppingmall.service.SellerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerProfileController {
    private final CustomerProfileService customerProfileService;
    private final SellerProfileService sellerProfileService;

    // 구매자 프로필 설정
    @PostMapping("/customer/profile")
    public CustomerProfileResponseDto createCustomerProfile(@RequestBody CustomerProfileRequestDto customerProfileRequestDto){
        return customerProfileService.createCustomProfile(customerProfileRequestDto);
    }

    @GetMapping("/customer/profile")
    public CustomerProfileResponseDto getProfileById(@PathVariable Long userId){
        return customerProfileService.getProfileById(userId);
    }

    // 판매자 등록(판매자 프로필 설정)
    @PostMapping("/customer/registration")
    public SellerProfileResponseDto createSellerProfile(@RequestBody SellerProfileRequestDto sellerProfileRequestDto) {
        return sellerProfileService.createSellerProfile(sellerProfileRequestDto);
    }
}
