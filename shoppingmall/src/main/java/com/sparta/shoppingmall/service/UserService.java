package com.sparta.shoppingmall.service;

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
    public void signUp(SignUpRequestDto signupRequestDto, UserRoleEnum role) {

        // 회원 중복 확인
        Optional<User> findUserId = userRepository.findByUsername(signupRequestDto.getUsername());
        if(findUserId.isPresent()){
            throw new CustomException(DUPLICATE_USER);
        }
        User user = new User(signupRequestDto.getUsername(), signupRequestDto.getPassword(), role);
        userRepository.save(user);
    }


    @Transactional(readOnly = true)
    public String signIn(SignInRequestDto signinRequestDto) {
        String username = signinRequestDto.getUsername();
        String password = signinRequestDto.getPassword();

        // 아이디 및 비밀먼호 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new CustomException(MEMBER_NOT_FOUND)
        );

        //로그인을 할 수 있는 사용자인지 확인을 한다.
        if(!user.isUserStatus()){
            throw new CustomException(MEMBER_IS_UNREGISTER);
        }else {
            if (!user.getPassword().equals(password) ) {
                throw new CustomException(INVALID_PASSWORD);
            } else {
                return jwtUtil.createToken(user.getUsername(),user.getRole());
            }
        }
    }

}