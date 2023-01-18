package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seller/")
public class SellerController {

    private final SellerService sellerService;

    // 고객의 주문 처리하기
    @PutMapping("/{orderId}")
    public ResponseEntity approveCustomerOrder(@PathVariable Long orderId) {
        return sellerService.approveCustomerOrder(orderId);
    }
}
