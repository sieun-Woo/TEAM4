package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.SellerProfileRequestDto;
import com.sparta.shoppingmall.dto.SellerProfileResponseDto;
import com.sparta.shoppingmall.entity.SellerProfile;
import com.sparta.shoppingmall.repository.SellerProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SellerProfileService {

    private final SellerProfileRepository sellerProfileRepository;
    public SellerProfileResponseDto createSellerProfile(SellerProfileRequestDto sellerProfileRequestDto) {
        SellerProfile sellerProfile = sellerProfileRepository.save(new SellerProfile(sellerProfileRequestDto));
        return new SellerProfileResponseDto(sellerProfile);
    }

    public SellerProfileResponseDto readMySellerProfile() {
//        sellerProfileRepository.findById();
        return null;
    }
}
