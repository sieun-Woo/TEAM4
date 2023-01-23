package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.*;
import com.sparta.shoppingmall.service.CustomerService;
import com.sparta.shoppingmall.service.RegistrationService;
import com.sparta.shoppingmall.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final ProductService productService;
    private final RegistrationService registrationService;

    // 구매자 프로필 설정
    @PostMapping("/customer/profile")
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto,
                                              @AuthenticationPrincipal UserDetails userDetails){
        return customerService.createCustomProfile(customerRequestDto,userDetails);
    }
    // 고객 프로필 조회
    @GetMapping("/customer/profile")
    public CustomerResponseDto getProfileById(@AuthenticationPrincipal UserDetails userDetails){
        return customerService.getProfileById(userDetails);
    }

    // 판매자 등록(판매자 프로필 설정)
    @PostMapping("/customer/registration")
    public ResponseEntity<String> createSellerProfile(@RequestBody RegistrationRequestDto registrationRequestDto,
                                              @AuthenticationPrincipal UserDetails userDetails) {
        return registrationService.createRegistration(registrationRequestDto, userDetails);
    }

    // 판매자 목록 조회
    @GetMapping("/customer/sellers")
    public List<RegistrationResponseDto> readSellers(@RequestParam("page") int page, @RequestParam("size") int size,
                                                      @RequestParam("sortBy") String sortBy, @RequestParam("isAsc") boolean isAsc) {

        // page 인덱스는 0부터 시작하기 때문에 page-1의 값을 인자로 하였다.
        return customerService.readSellers(page-1, size, sortBy, isAsc);
    }

    // 전체 판매 상품 목록 조회
    @GetMapping("/products")
    public List<ProductResponseDto> readProducts(@RequestParam("page") int page, @RequestParam("size") int size,
                                                 @RequestParam("sortBy") String sortBy, @RequestParam("isAsc") boolean isAsc
                                                 ) {

        // page 인덱스는 0부터 시작하기 때문에 page-1의 값을 인자로 하였다.
        return productService.readProducts(page-1, size, sortBy, isAsc);
    }

}
