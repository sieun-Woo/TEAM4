package com.sparta.shoppingmall.controller;

import com.sparta.shoppingmall.dto.ProductRequestDto;
import com.sparta.shoppingmall.dto.ProductResponseDto;
import com.sparta.shoppingmall.entity.Product;
import com.sparta.shoppingmall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seller/")
public class ProductController {

    private final ProductService productService;

    // 상품 등록하기
    @PostMapping("/product")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
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

    // 상품 목록 조회하기
    @GetMapping("/products")
    public List<Product> readProducts(@RequestParam("page") int page, @RequestParam("size") int size,
                                      @RequestParam("sortBy") String sortBy, @RequestParam("isAsc") boolean isAsc) {

        // page 인덱스는 0부터 시작하기 때문에 page-1의 값을 인자로 하였다.
        return productService.readProducts(page-1, size, sortBy, isAsc);
    }
}
