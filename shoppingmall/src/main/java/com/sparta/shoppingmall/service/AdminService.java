package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerProfileResponseDto;
import com.sparta.shoppingmall.dto.SellerProfileResponseDto;

import java.util.List;

public interface AdminService {
    List<CustomerProfileResponseDto> getCustomerList(); //고객 목록 조회

    List<SellerRegistrationDto> getSellerRegistrationList(); //판매자 등록 요청 조회

    void permitSellerRegister(SellerRegistrationDto sellerRegistrationDto);
    //판매자 권한 허가

    List<SellerProfileResponseDto> getSellerList(); //판매자 목록 조회

    void deleteSellerRegistration(Long authId); //판매자 권한 삭제
}
