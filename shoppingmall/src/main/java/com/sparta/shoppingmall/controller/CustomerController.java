package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.*;
import com.sparta.shoppingmall.entity.SellerProfile;
import com.sparta.shoppingmall.service.CustomerService;
import com.sparta.shoppingmall.service.ProductService;
import com.sparta.shoppingmall.service.SellerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final SellerProfileService sellerProfileService;
    private final ProductService productService;
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

    @GetMapping("/sellers")
    public List<SellerProfileResponseDto> readSellers(@RequestParam("page") int page, @RequestParam("size") int size,
                                            @RequestParam("sortBy") String sortBy, @RequestParam("isAsc") boolean isAsc) {

        // page 인덱스는 0부터 시작하기 때문에 page-1의 값을 인자로 하였다.
        return customerService.readSellers(page-1, size, sortBy, isAsc);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> readProducts(@RequestParam("page") int page, @RequestParam("size") int size,
                                                 @RequestParam("sortBy") String sortBy, @RequestParam("isAsc") boolean isAsc) {

        // page 인덱스는 0부터 시작하기 때문에 page-1의 값을 인자로 하였다.
        return productService.readProducts(page-1, size, sortBy, isAsc);
    }

    @GetMapping("/sellers")
    public List<ProductResponseDto> allProducts(Pageable pageable){
        return productService.findAll(pageable).get;
    }
  
}
