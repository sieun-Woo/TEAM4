package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.RegistrationRequestDto;
import com.sparta.shoppingmall.entity.Registration;
import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.repository.RegistrationRepository;
import com.sparta.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;

    public ResponseEntity<String> createRegistration(RegistrationRequestDto registrationRequestDto, UserDetails userDetails) {

        User user = userRepository.findByUsername(userDetails.getUsername()).get();

        Optional<Registration> registration = registrationRepository.findByUserId(user.getId());

        // 판매자 등록 한 번만
        if (registration.isPresent()) {
            throw new IllegalArgumentException("이미 요청하셨습니다.");
        }
        
        registrationRepository.saveAndFlush(new Registration(registrationRequestDto, user.getId()));

        return new ResponseEntity<>("판매자 등록이 요청되었습니다.", HttpStatus.OK);
    }

}
