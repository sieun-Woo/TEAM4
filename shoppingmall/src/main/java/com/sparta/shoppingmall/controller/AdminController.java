package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.CustomerProfileResponseDto;
import com.sparta.shoppingmall.dto.SellerProfileResponseDto;
import com.sparta.shoppingmall.service.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class AdminController {

    private final AdminServiceImpl adminServiceImpl;

    //판매자 등록 요청 조회
    @GetMapping("/admin/seller-registrations")
    public List<SellerRegistrationDto> getSellerRegistrationList() {
        return adminServiceImpl.getSellerRegistrationList();
    }

    //판매자 등록 승인
    @PutMapping("/admin/seller-registration/{authId}")
    public ResponseEntity<String> permitSellerRegister(@RequestBody SellerRegistrationDto sellerRegistrationDto){
        adminServiceImpl.permitSellerRegister(sellerRegistrationDto);
        return new ResponseEntity<>("판매자 등록이 승인되었습니다.", HttpStatus.OK);
    }

    //고객 목록 조회`
    @GetMapping("/admin/customers")
    public ResponseEntity<List<CustomerProfileResponseDto>> getCustomerList(){
        List<CustomerProfileResponseDto> data = adminServiceImpl.getCustomerList();
        return ResponseEntity.status(200).body(data);
    }

    //판매자 목록 조회
    @GetMapping("/admin/sellers")
    public List<SellerProfileResponseDto> getSellerList() {
        return adminServiceImpl.getSellerList();
    }

    //판매자 권한 삭제
    @PutMapping("/admin/seller-registration/{authId}")
    public ResponseEntity<String> deleteSellerRegistration(@PathVariable Long authId){
        adminServiceImpl.deleteSellerRegistration(authId);
        return new ResponseEntity<>("판매자 권한 삭제 완료", HttpStatus.OK);
    }
}