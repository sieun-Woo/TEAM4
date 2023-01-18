package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final OrderRepository orderRepository;
    public ResponseEntity<String> approveCustomerOrder(Long orderId) {
        Order order = orderRepository.findById(ordertId).orElseThrow(() -> new IllegalArgumentException("해당하는 주문이 없습니다."));
        order.setOrderState(true);
        // 수정 이후에 flush 하여 DB에 반영하였다.
        orderRepository.flush();

        return new ResponseEntity<>("주문한 상품을 발송하였습니다.", HttpStatus.OK);

    }
}
