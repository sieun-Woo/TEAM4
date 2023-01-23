package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.ProductRequestDto;
import com.sparta.shoppingmall.dto.ProductResponseDto;
import com.sparta.shoppingmall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seller/")
@PreAuthorize("hasAnyRole('ROLE_SELLER')")
public class ProductController {

    private final ProductService productService;

    // 상품 등록하기
    @PostMapping("/product")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto,
                                            @AuthenticationPrincipal UserDetails userDetails) {
        return productService.createProduct(productRequestDto, userDetails);
    }

    // 상품 수정하기
    @PutMapping("/product/{productId}")
    public ProductResponseDto updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateProduct(productId, productRequestDto);
    }

    // 상품 삭제하기
    @DeleteMapping("/product/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }

    /*
        나의 판매 상품 목록 조회하기
        @RequestParam을 통해 페이징에 대한 정보를 클라이언트로부터 받습니다.
        page : 조회할 페이지
        size : 한 페이지에 들어가는 조회 목록 크기
        sortBy : 어떤 Column을 기준으로 정렬할 것인지 구분
        isAsc : 오름차순(true)으로 정렬할 것인지 내림차순(false)으로 정렬할 것인지 구분
    */
    @GetMapping("/products")
    public List<ProductResponseDto> readProducts(@RequestParam("page") int page, @RequestParam("size") int size,
                                                 @RequestParam("sortBy") String sortBy, @RequestParam("isAsc") boolean isAsc,
                                                 @AuthenticationPrincipal UserDetails userDetails) {

        // page 인덱스는 0부터 시작하기 때문에 page-1의 값을 인자로 하였다.
        return productService.myReadProducts(page-1, size, sortBy, isAsc, userDetails);
    }

}
