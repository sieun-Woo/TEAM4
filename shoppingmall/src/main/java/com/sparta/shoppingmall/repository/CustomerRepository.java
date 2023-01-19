package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
