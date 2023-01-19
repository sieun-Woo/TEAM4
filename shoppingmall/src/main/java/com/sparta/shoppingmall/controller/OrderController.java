package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.OrderRequestDto;
import com.sparta.shoppingmall.dto.OrderResponseDto;
import com.sparta.shoppingmall.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/customer/order")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto, @AuthenticationPrincipal UserDetails userDetails){
        return orderService.createOrder(orderRequestDto,userDetails.getUsername());
    }
}
