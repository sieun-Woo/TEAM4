package com.sparta.shoppingmall.entity;

public enum UserRoleEnum {
    CUSTOMER(Authority.CUSTOMER),  // 고객 권한
    SELLER(Authority.SELLER), // 판매자 권한
    ADMIN(Authority.ADMIN);  // 관리자 권한

    private final String authority;

    UserRoleEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String CUSTOMER = "ROLE_CUSTOMER";
        public static final String SELLER = "ROLE_SELLER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}
