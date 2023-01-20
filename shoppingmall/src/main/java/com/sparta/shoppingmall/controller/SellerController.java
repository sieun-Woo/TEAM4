package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.OrderResponseDto;
import com.sparta.shoppingmall.dto.RegistrationResponseDto;
import com.sparta.shoppingmall.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seller/")
@PreAuthorize("hasAnyRole('ROLE_SELLER')")
public class SellerController {

    private final SellerService sellerService;

    // 모든상품의 고객요청 목록을 페이징하여 조회
    @GetMapping("/orders")
    public List<OrderResponseDto> readOrders(@RequestParam("page") int page, @RequestParam("size") int size,
                                             @RequestParam("sortBy") String sortBy, @RequestParam("isAsc") boolean isAsc) {
        return sellerService.readOrders(page-1, size, sortBy, isAsc);
    }

    // 고객의 주문 처리하기
    @PutMapping("/order/{orderId}")
    public ResponseEntity approveCustomerOrder(@PathVariable Long orderId) {
        return sellerService.approveCustomerOrder(orderId);
    }

    // 나의 판매자 프로필 조회
    @GetMapping("/profile")
    public RegistrationResponseDto readSellerProfile(@AuthenticationPrincipal UserDetails userDetails) {
        return sellerService.readSellerProfile(userDetails);
    }
}
