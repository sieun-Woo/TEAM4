package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
}
