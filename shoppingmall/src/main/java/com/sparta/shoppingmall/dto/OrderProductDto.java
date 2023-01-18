package com.sparta.shoppingmall.dto;

import com.sparta.shoppingmall.entity.OrderProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductDto {
    private String name;
    private int count;
    private int orderPrice;

    public OrderProductDto(OrderProduct orderProduct, String imgUrl) {
        this.name = orderProduct.getProduct().getName();
        this.count = orderProduct.getCount();
        this.orderPrice = orderProduct.getOrderPrice();
    }
}
