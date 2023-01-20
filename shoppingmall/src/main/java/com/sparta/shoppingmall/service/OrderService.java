package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.OrderRequestDto;
import com.sparta.shoppingmall.dto.OrderResponseDto;
import com.sparta.shoppingmall.entity.Order;

import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.repository.OrderRepository;
import com.sparta.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto, String username) {

        User user = userRepository.findByUsername(username).get();
        Order order = orderRepository.saveAndFlush(new Order(user, orderRequestDto));

        return new OrderResponseDto(order);
    }
}
