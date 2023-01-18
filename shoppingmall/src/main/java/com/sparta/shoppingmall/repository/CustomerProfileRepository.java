package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {

    Optional<CustomerProfile> findById(Long id);

    Optional<CustomerProfile> findByNickname(String nickname);

}
