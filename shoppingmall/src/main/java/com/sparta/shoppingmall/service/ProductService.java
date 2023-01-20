package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.ProductRequestDto;
import com.sparta.shoppingmall.dto.ProductResponseDto;
import com.sparta.shoppingmall.entity.Product;
import com.sparta.shoppingmall.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;


    @Transactional
    // 상품 등록하기
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productRepository.saveAndFlush(new Product(productRequestDto));
        return new ProductResponseDto(product);
    }

    @Transactional
    // 상품 수정하기
    public ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto) {
        // 등록된 id가 없다면 예외가 발생한다.
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException());
        product.update(productRequestDto);
        // 수정 이후에 flush 하여 DB에 반영하였다.
        productRepository.flush();

        return new ProductResponseDto(productRepository.findById(product.getId()).get());
    }

    // 상품 삭제하기
    @Transactional
    public ResponseEntity deleteProduct(Long productId) {
        // 등록된 id가 없다면 예외가 발생한다.
        productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException());
        productRepository.deleteById(productId);
        return new ResponseEntity("상품이 삭제 되었습니다.", HttpStatus.OK);
    }

    // 상품 조회하기
    @Transactional
    public List<ProductResponseDto> readProducts(int page, int size, String sortBy, boolean isAsc) {
        // 페이징 처리
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        // 현재 프론트을 사용하고 있지 않기 때문에 페이징 처리한 정보들을 리스트 형식을 반환하였다.
        Iterator<Product> products = productRepository.findAll(pageable).getContent().iterator();
        ArrayList<ProductResponseDto> productResponseDtoArrayList = new ArrayList<>();
        while (products.hasNext()) {
            productResponseDtoArrayList.add(new ProductResponseDto(products.next()));
        }

        return productResponseDtoArrayList;
    }

    private final ProductRequestDto productRequestDto;
    /*public void findAll(Pageable pageable){
        productRepository.findByUserOrderByIdDesc(createProduct(productRequestDto),pageable)
                .map(ProductResponseDto::new);
    }*/

}
