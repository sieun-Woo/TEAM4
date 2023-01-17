package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.SellerProfileRequestDto;
import com.sparta.shoppingmall.dto.SellerProfileResponseDto;
import com.sparta.shoppingmall.service.SellerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seller/")
public class SellerController {

    private final SellerProfileService sellerProfileService;

    // 판매자 프로필 조회만


}
