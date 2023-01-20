package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.RegistrationRequestDto;
import com.sparta.shoppingmall.dto.RegistrationResponseDto;
import com.sparta.shoppingmall.entity.Customer;
import com.sparta.shoppingmall.entity.Registration;
import com.sparta.shoppingmall.repository.CustomerProfileRepository;
import com.sparta.shoppingmall.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final CustomerProfileRepository customerProfileRepository;

    public RegistrationResponseDto createRegistration(RegistrationRequestDto registrationRequestDto, UserDetails userDetails) {

         Customer customer = customerProfileRepository.findByUsername(userDetails.getUsername()).get();

        Registration registration = registrationRepository.save(new Registration(registrationRequestDto,customer.getId()));
        return new RegistrationResponseDto(registration.getId());
    }

}
