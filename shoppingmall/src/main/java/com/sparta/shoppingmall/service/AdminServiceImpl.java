package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerResponseDto;
import com.sparta.shoppingmall.dto.SellerProfileResponseDto;
import com.sparta.shoppingmall.dto.SellerRegistrationDto;
import com.sparta.shoppingmall.entity.Customer;
import com.sparta.shoppingmall.repository.CustomerRepository;
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

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponseDto> getCustomerList() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> resultDto = new ArrayList<>();
        customerList.forEach(customer -> resultDto.add(CustomerResponseDto.add(customer)));
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
