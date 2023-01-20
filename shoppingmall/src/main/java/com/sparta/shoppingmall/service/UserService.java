package com.sparta.shoppingmall.service;

import com.sparta.shoppingmall.dto.SignInRequestDto;
import com.sparta.shoppingmall.dto.SignUpRequestDto;
import com.sparta.shoppingmall.dto.SignupResponseDto;
import com.sparta.shoppingmall.entity.User;
import com.sparta.shoppingmall.entity.UserRoleEnum;
import com.sparta.shoppingmall.exception.CustomException;
import com.sparta.shoppingmall.exception.ErrorCode;
import com.sparta.shoppingmall.jwt.JwtUtil;
import com.sparta.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public SignupResponseDto signUp(SignUpRequestDto signupRequestDto, UserRoleEnum role) {

        // 회원 중복 확인
        Optional<User> findUserId = userRepository.findByUsername(signupRequestDto.getUsername());
        if(findUserId.isPresent()){
            throw new CustomException(ErrorCode.EXISTS_ID);
        }
        User user = new User(signupRequestDto.getUsername(), signupRequestDto.getPassword(), role);
        userRepository.save(user);
        return new SignupResponseDto("200","회원가입 성공!");
    }


    @Transactional(readOnly = true)
    public String signIn(SignInRequestDto signinRequestDto) {
        String username = signinRequestDto.getUsername();
        String password = signinRequestDto.getPassword();

        // 아이디 및 비밀먼호 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new CustomException(ErrorCode.ID_NOT_FOUND)
        );

        //로그인을 할 수 있는 사용자인지 확인을 한다.

            if (!user.getPassword().equals(password) ) {
                throw new CustomException(ErrorCode.PASSWORD_NOT_FOUND);
            } else {
                return jwtUtil.createToken(user.getUsername(),user.getRole());
            }

    }

}