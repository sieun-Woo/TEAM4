package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerProfileRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);

    Optional<Customer> findByNickname(String nickname);

    Optional<Customer> findByUsername(String username);

}
