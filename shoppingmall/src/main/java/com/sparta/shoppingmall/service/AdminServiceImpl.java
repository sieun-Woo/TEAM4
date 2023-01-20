package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerProfileResponseDto;
import com.sparta.shoppingmall.entity.CustomerProfile;
import com.sparta.shoppingmall.repository.CustomerProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final CustomerProfileRepository customerProfileRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerProfileResponseDto> getCustomerList() {
        List<CustomerProfile> customerList = customerProfileRepository.findAll();
        List<CustomerProfileResponseDto> resultDto = new ArrayList<>();
        customerList.forEach(customer -> resultDto.add(CustomerProfileResponseDto.add(customer)));
        return resultDto;
    }

    @Override
    public List<SellerRegistrationDto> getSellerRegistrationList() {
        return null;
    }

    @Override
    public ResponseEntity<String> permitSellerRegister(SellerRegistrationDto sellerRegistrationDto) {
        return null;
    }

    @Override
    public List<SellerProfileResponseDto> getSellerList() {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteSellerRegistration(Long authId) {
        return null;
    }
}
