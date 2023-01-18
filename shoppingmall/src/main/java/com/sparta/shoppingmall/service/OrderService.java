package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.OrderRequestDto;
import com.sparta.shoppingmall.entity.Order;
import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public OrderRequestDto createOrder(User user, OrderRequestDto orderRequestDto) {
        Order order = orderRepository.saveAndFlush(new Order(user));

        return new OrderRequestDto(order);
    }
}
