package com.sparta.shoppingmall.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorCode {
    ID_NOT_FOUND(HttpStatus.NOT_FOUND,"아이디를 찾을 수 없습니다."),
    PASSWORD_NOT_FOUND(HttpStatus.NOT_FOUND,"비밀번호를 찾을 수 없습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,"유저를 찾을 수 없습니다."),

    INVALID_ADMIN_PASSWORD(HttpStatus.BAD_REQUEST,"관리자 비밀번호가 다릅니다."),

    EXISTS_ID(HttpStatus.BAD_REQUEST,"이미 존재하는 아이디입니다."),
    WRONG_ID(HttpStatus.BAD_REQUEST,"아이디가 틀립니다."),

    WRONG_PASSWORD(HttpStatus.BAD_REQUEST,"비밀번호가 틀립니다."),;

    private final HttpStatus status;
    private final String message;




}
