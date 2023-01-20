package com.sparta.shoppingmall.repository;

import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.entity.UserRoleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findAllByRole(UserRoleEnum role);

    Page<User> findAllByRole(UserRoleEnum role, Pageable pageable);

}

