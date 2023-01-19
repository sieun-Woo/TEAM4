package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.CustomerRequestDto;
import com.sparta.shoppingmall.dto.CustomerResponseDto;
import com.sparta.shoppingmall.dto.SellerProfileRequestDto;
import com.sparta.shoppingmall.dto.SellerProfileResponseDto;
import com.sparta.shoppingmall.service.CustomerService;
import com.sparta.shoppingmall.service.SellerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final SellerProfileService sellerProfileService;

    // 구매자 프로필 설정
    @PostMapping("/customer/profile")
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.createCustomProfile(customerRequestDto);
    }

    @GetMapping("/customer/profile")
    public CustomerResponseDto getProfileById(@PathVariable Long userId){
        return customerService.getProfileById(userId);
    }

    // 판매자 등록(판매자 프로필 설정)
    @PostMapping("/customer/registration")
    public SellerProfileResponseDto createSellerProfile(@RequestBody SellerProfileRequestDto sellerProfileRequestDto) {
        return sellerProfileService.createSellerProfile(sellerProfileRequestDto);
    }
}
