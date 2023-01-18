package com.sparta.shoppingmall.entity;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "order_item")

public class Order extends Timestamped{



}
