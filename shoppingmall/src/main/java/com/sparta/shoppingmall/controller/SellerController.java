package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.OrderResponseDto;
import com.sparta.shoppingmall.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seller/")
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/orders")
    public List<OrderResponseDto> readOrders(@RequestParam("page") int page, @RequestParam("size") int size,
                                             @RequestParam("sortBy") String sortBy, @RequestParam("isAsc") boolean isAsc) {
        return sellerService.readOrders(page-1, size, sortBy, isAsc);
    }

    // 고객의 주문 처리하기
    @PutMapping("/{orderId}")
    public ResponseEntity approveCustomerOrder(@PathVariable Long orderId) {
        return sellerService.approveCustomerOrder(orderId);
    }
}
