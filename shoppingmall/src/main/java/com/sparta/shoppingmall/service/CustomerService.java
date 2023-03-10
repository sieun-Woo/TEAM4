package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerRequestDto;
import com.sparta.shoppingmall.dto.CustomerResponseDto;
import com.sparta.shoppingmall.dto.RegistrationResponseDto;
import com.sparta.shoppingmall.entity.Customer;
import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.repository.CustomerProfileRepository;
import com.sparta.shoppingmall.repository.RegistrationRepository;
import com.sparta.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static com.sparta.shoppingmall.entity.UserRoleEnum.SELLER;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerProfileRepository customerProfileRepository;
    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final CustomerProfileRepository customerRepository;
    public CustomerResponseDto createCustomProfile(CustomerRequestDto customerRequestDto,UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).get();


        Optional<Customer> customerProfile = customerRepository.findById(user.getId());

        if (customerProfile.isPresent()) {
            throw new IllegalArgumentException("이미 요청하셨습니다.");
        }
        Customer customProfile = customerProfileRepository.saveAndFlush(new Customer(customerRequestDto, user.getUsername()));
        return new CustomerResponseDto(customProfile);
    }

    public CustomerResponseDto getProfileById(UserDetails userDetails) {
        Customer customer = customerProfileRepository.findByUsername(userDetails.getUsername()).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );
        return new CustomerResponseDto(customer);
    }

    public List<RegistrationResponseDto> readSellers(int page, int size, String sortBy, boolean isAsc) {
        // 페이징 처리
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        // 현재 프론트을 사용하고 있지 않기 때문에 페이징 처리한 정보들을 리스트 형식을 반환하였다.
        Iterator<User> sellers = userRepository.findAllByRole(SELLER, pageable).getContent().iterator();
        ArrayList<RegistrationResponseDto> selllerResponseDtoArrayList = new ArrayList<>();
        while (sellers.hasNext()) {
            selllerResponseDtoArrayList.add(new RegistrationResponseDto
                    (registrationRepository.findByUserId(sellers.next().getId()).get()));
        }

        return selllerResponseDtoArrayList;
    }

}
