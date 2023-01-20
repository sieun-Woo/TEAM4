package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.OrderResponseDto;
import com.sparta.shoppingmall.dto.RegistrationResponseDto;
import com.sparta.shoppingmall.entity.Order;
import com.sparta.shoppingmall.entity.Registration;
import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.repository.OrderRepository;
import com.sparta.shoppingmall.repository.RegistrationRepository;
import com.sparta.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final RegistrationRepository registrationRepository;

    @Transactional
    public ResponseEntity<String> approveCustomerOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("해당하는 주문이 없습니다."));
        order.setOrderStatus();
        // 수정 이후에 flush 하여 DB에 반영하였다.
        orderRepository.flush();

        return new ResponseEntity<>("주문한 상품을 발송하였습니다.", HttpStatus.OK);

    }

    // 고객요청(주문) 목록 조회
    @Transactional
    public List<OrderResponseDto> readOrders(int page, int size, String sortBy, boolean isAsc) {
        // 페이징 처리
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        // 현재 프론트을 사용하고 있지 않기 때문에 페이징 처리한 정보들을 리스트 형식을 반환하였다.
        Iterator<Order> orders = orderRepository.findAll(pageable).getContent().iterator();
        ArrayList<OrderResponseDto> orderResponseDtoArrayList = new ArrayList<>();
        while (orders.hasNext()) {
            orderResponseDtoArrayList.add(new OrderResponseDto(orders.next()));
        }

        return orderResponseDtoArrayList;
    }

    // 나의 판매자 프로필 조회
    @Transactional
    public RegistrationResponseDto readSellerProfile(UserDetails userDetails) {
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username).get();
        Registration registration = registrationRepository.findByUserId(user.getId()).get();
        return new RegistrationResponseDto(registration.getId());
    }


}
