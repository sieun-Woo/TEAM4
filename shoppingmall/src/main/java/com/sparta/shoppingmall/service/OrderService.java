package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.OrderRequestDto;
import com.sparta.shoppingmall.dto.OrderResponseDto;
import com.sparta.shoppingmall.entity.Order;
import com.sparta.shoppingmall.entity.Product;
import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.repository.OrderRepository;
import com.sparta.shoppingmall.repository.ProductRepository;
import com.sparta.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto, String username) {

        Iterator<Long> productIdList = orderRequestDto.getProductList().iterator();

        List<Product> productList = new ArrayList<>();

        while(productIdList.hasNext()) {
            productList.add(productRepository.findById(productIdList.next()).get());
        }

        User user = userRepository.findByUsername(username).get();
        Order order = orderRepository.saveAndFlush(new Order(user, orderRequestDto, productList));

        return new OrderResponseDto(order);
    }
}
