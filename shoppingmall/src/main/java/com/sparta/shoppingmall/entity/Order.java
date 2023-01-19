package com.sparta.shoppingmall.entity;

import com.sparta.shoppingmall.dto.OrderRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(name ="userId")
    private User user;

    @OneToMany(mappedBy ="order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Product> orderProducts = new ArrayList<>();

    @Column
    private int price;
    @Column
    private String requireComment; // 요구 사항
    @Column
    private String addressee; // 수령인
    @Column
    private String address; // 주소
    @Column
    private String phone; // 연락처
    @Column
    private boolean orderStatus; // 주문 상태

    public void setOrderStatus() {
        this.orderStatus = true;
    }



    public Order(User user,OrderRequestDto orderRequestDto) {
        List<Product> orderProducts = new ArrayList<>();
        for (Product orderProduct : orderProducts) {
            orderProducts.add(orderProduct);
        }
        this.user = user;
        this.orderProducts = orderProducts;
        this.price = getTotalPrice(orderProducts);
        this.requireComment = orderRequestDto.getRequireComment();
        this.addressee = orderRequestDto.getAddressee();
        this.address = orderRequestDto.getAddress();
        this.phone = orderRequestDto.getPhone();
        this.orderStatus =false;
    }



    public int getTotalPrice(List<Product> orderProducts) {
        int totalPrice = 0;

        for (Product orderProduct : orderProducts) {
            totalPrice += orderProduct.getPrice();
        }
        return totalPrice;
    }



}
