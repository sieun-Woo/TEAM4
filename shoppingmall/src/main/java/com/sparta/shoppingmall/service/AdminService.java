package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerProfileResponseDto;
import com.sparta.shoppingmall.dto.RegistrationRequestDto;
import com.sparta.shoppingmall.dto.RegistrationResponseDto;
import com.sparta.shoppingmall.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    List<CustomerProfileResponseDto> getCustomerList(); //고객 목록 조회

    List<RegistrationResponseDto> getSellerRegistrationList(); //판매자 등록 요청 조회

    //판매자 권한 허가

    void permitSellerRegister(RegistrationRequestDto registrationRequestDto, Long id);

    List<RegistrationResponseDto> getSellerList(); //판매자 목록 조회

    void deleteSellerRegistration(Long id); //판매자 권한 삭제
}
