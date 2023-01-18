package com.sparta.shoppingmall.admin.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    //판매자 등록 요청 조회
    @GetMapping("/admin/seller-registrations")
    public List<SellerRegistrationDto> getSellerRegistrationList() {
        return adminServiceImpl.getSellerRegistrationList();
    }

    //판매자 등록 승인
    @PutMapping("/admin/seller-registration/{authId}")
    public ResponseEntity<String> permitSellerRegister(@RequestBody SellerRegistrationDto sellerRegistrationDto){
        adminServiceImpl.permitSellerRegister();
        return new ResponseEntity<>("판매자 등록이 승인되었습니다.", HttpStatus.OK);
    }

    //고객 목록 조회`
    @GetMapping("/admin/customers")
    public List<ResponseCustomerDto> getCustomerList(){
        return adminServiceImpl.getCustomerList();
    }


    //판매자 목록 조회
    @GetMapping("/admin/sellers")
    public List<ResponseSellerDto> getSellerList() {
        return adminServiceImpl.getSellerList();
    }

    //판매자 권한 삭제
    @PutMapping("/admin/seller-registration/{authId}")
    public ResponseEntity<String> deleteSellerRegistration(@PathVariable Long authId){
        adminServiceImpl.deleteSellerRegistration(authId);
        return new ResponseEntity<>("판매자 권한 삭제 완료", HttpStatus.OK);
    }
}