package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.CustomerProfile;
import com.sparta.shoppingmall.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
