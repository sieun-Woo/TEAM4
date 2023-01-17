package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerProfileRequestDto;
import com.sparta.shoppingmall.dto.CustomerProfileResponseDto;
import com.sparta.shoppingmall.entity.CustomerProfile;
import com.sparta.shoppingmall.repository.CustomerProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerProfileService {
    private final CustomerProfileRepository customerProfileRepository;
    public CustomerProfileResponseDto createCustomProfile(CustomerProfileRequestDto customerProfileRequestDto) {
        CustomerProfile customProfile = customerProfileRepository.saveAndFlush(new CustomerProfile(customerProfileRequestDto));
        return new CustomerProfileResponseDto(customProfile);
    }
}
