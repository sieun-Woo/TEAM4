package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Optional<Registration> findByUserId(Long userId);
//    Optional<Registration> findById(Long id);

}
