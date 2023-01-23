package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerProfileResponseDto;
import com.sparta.shoppingmall.dto.RegistrationRequestDto;
import com.sparta.shoppingmall.dto.RegistrationResponseDto;
import com.sparta.shoppingmall.entity.Customer;
import com.sparta.shoppingmall.entity.Registration;
import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.entity.UserRoleEnum;
import com.sparta.shoppingmall.repository.CustomerProfileRepository;
import com.sparta.shoppingmall.repository.RegistrationRepository;
import com.sparta.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

//    private final CustomerProfileRepository customerProfileRepository;
    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationResponseDto> getCustomerList() {
        Optional<User> customerList = userRepository.findAllByRole(UserRoleEnum.CUSTOMER);
        return customerList.stream().map(RegistrationResponseDto::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationResponseDto> getSellerRegistrationList() {
        List<Registration> registrationList = registrationRepository.findAll();
        List<RegistrationResponseDto> resultDto = new ArrayList<>();
        registrationList.forEach(registration -> resultDto.add(RegistrationResponseDto.add(registration)));
        return resultDto;
    }

    //판매자 등록 요청 승인
    @Override
    @Transactional
    public void permitSellerRegister(RegistrationRequestDto registrationRequestDto, Long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 ID가 없습니다.")
        );
        Long userId = registration.getUserId();
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );
        user.customerToSeller(registration);
//        List<RegistrationResponseDto> data =  getSellerList();
    }

    //판매자 목록 조회
    @Override
    @Transactional
    public List<RegistrationResponseDto> getSellerList() {

        Optional<User> sellerList = userRepository.findAllByRole(UserRoleEnum.SELLER);
        return sellerList.stream().map(RegistrationResponseDto::new).collect(Collectors.toList());
    }

    //판매자 권한 삭제
    @Override
    @Transactional
    public void deleteSellerRegistration(Long authId) {
        User user = userRepository.findById(authId).orElseThrow(
                () -> new IllegalArgumentException("유저를 찾을 수 없습니다.")
        );
        if(!user.getRole().equals(UserRoleEnum.SELLER)){
            throw new IllegalArgumentException("판매자가 아닙니다.");
        } else {
            user.sellerToCustomer();
        }
    }
}
