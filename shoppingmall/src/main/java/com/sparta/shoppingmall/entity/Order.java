package com.sparta.shoppingmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

   // private LocalDateTime orderDate; //주문일

    @Column
    private boolean orderStatus; //주문상태

    // order_product 테이블의 order 필드에 매핑
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderProduct> orderProducts = new ArrayList<>();


    public Order(User user) {
        this.user = user;
        for (OrderProduct orderProduct : orderProducts) {
            orderProducts.add(orderProduct);
        }
    }

    /*public Order createOrder(Member member, List<OrderProduct> orderProductList) {

        Order order = new Order();
        order.setMember(member);
        for (OrderProduct orderProduct : orderProductList) {
            orderProducts.add(orderProduct);
        }
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.ORDER);
        return order;
    }*/

    public int getTotalPrice() {
        int totalPrice = 0;

        for (OrderProduct orderProduct : orderProducts) {
            totalPrice += orderProduct.getTotalPrice();
        }
        return totalPrice;
    }

   /* public void orderCancel() {

        this.orderStatus = OrderStatus.CANCEL;
        for (OrderProduct orderProduct : orderProducts) {
            orderProduct.cancel();
        }
    }*/


}
