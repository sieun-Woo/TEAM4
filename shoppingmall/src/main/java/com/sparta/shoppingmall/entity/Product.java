package com.sparta.shoppingmall.entity;

import com.sparta.shoppingmall.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Product extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="userId")
    User user;

    @Column
    private String name;

    @Column
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORDER_ID", nullable = false)
    private Order order;

    public Product(ProductRequestDto productRequestDto) {
        this.name = productRequestDto.getName();
        this.price = productRequestDto.getPrice();
    }

    public void update(ProductRequestDto productRequestDto) {
        this.name = productRequestDto.getName();
        this.price = productRequestDto.getPrice();
    }

}
