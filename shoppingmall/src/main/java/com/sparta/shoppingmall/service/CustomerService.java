package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.CustomerRequestDto;
import com.sparta.shoppingmall.dto.CustomerResponseDto;

import com.sparta.shoppingmall.dto.SellerProfileResponseDto;
import com.sparta.shoppingmall.entity.Customer;

import com.sparta.shoppingmall.entity.SellerProfile;
import com.sparta.shoppingmall.repository.CustomerProfileRepository;
import com.sparta.shoppingmall.repository.SellerProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerProfileRepository customerProfileRepository;
    private final SellerProfileRepository sellerProfileRepository;

    public CustomerResponseDto createCustomProfile(CustomerRequestDto customerRequestDto) {
        Customer customProfile = customerProfileRepository.saveAndFlush(new Customer(customerRequestDto));
        return new CustomerResponseDto(customProfile);
    }

    public CustomerResponseDto getProfileById(Long userId) {
        Customer customer = customerProfileRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );
        return new CustomerResponseDto(customer);
    }

    public List<SellerProfileResponseDto> readSellers(int page, int size, String sortBy, boolean isAsc) {
        // 페이징 처리
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        // 현재 프론트을 사용하고 있지 않기 때문에 페이징 처리한 정보들을 리스트 형식을 반환하였다.
        Iterator<SellerProfile> sellers = sellerProfileRepository.findAll(pageable).getContent().iterator();
        ArrayList<SellerProfileResponseDto> selllerResponseDtoArrayList = new ArrayList<>();
        while (sellers.hasNext()) {
            selllerResponseDtoArrayList.add(new SellerProfileResponseDto(sellers.next()));
        }

        return selllerResponseDtoArrayList;
    }

}
