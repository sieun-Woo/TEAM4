package com.sparta.shoppingmall.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "order_product")
public class OrderProduct extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;

    public OrderProduct() {
    }

    // 전체 금액
    public int getTotalPrice() {
        return this.orderPrice * this.count;
    }
}
