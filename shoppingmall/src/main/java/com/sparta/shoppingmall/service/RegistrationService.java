package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.RegistrationRequestDto;
import com.sparta.shoppingmall.entity.Customer;
import com.sparta.shoppingmall.entity.Registration;
import com.sparta.shoppingmall.repository.CustomerRepository;
import com.sparta.shoppingmall.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final CustomerRepository customerRepository;

    public void createRegistration(RegistrationRequestDto registrationRequestDto, UserDetails userDetails) {

         Customer customer = customerRepository.findByUsername(userDetails.getUsername()).get();

        registrationRepository.save(new Registration(registrationRequestDto,customer.getId()));

    }

}
