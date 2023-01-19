package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter

public class OrderResponseDto {
    private int price;
    private LocalDateTime orderAt;
    private String requireComment;
    private String addressee;
    private String address;
    private String phone;
    private boolean orderStatus;

    public OrderResponseDto(Order order) {
        this.price = order.getPrice();
        this.orderAt = order.getCreateAt();
        this.requireComment = order.getRequireComment();
        this.addressee = order.getAddressee();
        this.address = order.getAddress();
        this.phone = order.getPhone();
        this.orderStatus = order.isOrderStatus();
    }
}
