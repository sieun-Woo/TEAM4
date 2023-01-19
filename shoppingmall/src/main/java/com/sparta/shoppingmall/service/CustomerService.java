package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerRequestDto;
import com.sparta.shoppingmall.dto.CustomerResponseDto;
import com.sparta.shoppingmall.entity.Customer;
import com.sparta.shoppingmall.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerResponseDto createCustomProfile(CustomerRequestDto customerRequestDto) {
        Customer customProfile = customerRepository.saveAndFlush(new Customer(customerRequestDto));
        return new CustomerResponseDto(customProfile);
    }

    public CustomerResponseDto getProfileById(Long userId) {
        Customer customer = customerRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );
        return new CustomerResponseDto(customer);
    }
}
