package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.SellerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerProfileRepository extends JpaRepository<SellerProfile, Long> {
    Optional<SellerProfile> findByUsername(String username);
}
