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

    public static OrderProduct createOrderProduct(Product product, int count) {

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(product);
        orderProduct.setCount(count);
        orderProduct.setOrderPrice(product.getPrice());

        product.removeStock(count);
        return orderProduct;
    }

    // 전체 금액
    public int getTotalPrice() {
        return this.orderPrice * this.count;
    }
}
