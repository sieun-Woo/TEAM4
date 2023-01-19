package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.CustomerRequestDto;
import com.sparta.shoppingmall.dto.CustomerResponseDto;
import com.sparta.shoppingmall.dto.RegistrationRequestDto;
import com.sparta.shoppingmall.service.CustomerService;
import com.sparta.shoppingmall.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final RegistrationService registrationService;

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
    public ResponseEntity<String> createSellerProfile(@RequestBody RegistrationRequestDto registrationRequestDto,
                                                                      @AuthenticationPrincipal UserDetails userDetails) {
        registrationService.createRegistration(registrationRequestDto, userDetails);
        return new ResponseEntity<>("판매자 등록이 요청 되었습니다.", HttpStatus.OK);
    }
}
