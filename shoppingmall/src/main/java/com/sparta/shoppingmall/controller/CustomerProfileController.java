package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.CustomerProfileRequestDto;
import com.sparta.shoppingmall.dto.CustomerProfileResponseDto;
import com.sparta.shoppingmall.service.CustomerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerProfileController {
    private final CustomerProfileService customerProfileService;
    @PostMapping("/customer/profile")
    public CustomerProfileResponseDto createCustomerProfile(@RequestBody CustomerProfileRequestDto customerProfileRequestDto){
        return customerProfileService.createCustomProfile(customerProfileRequestDto);
    }
}
