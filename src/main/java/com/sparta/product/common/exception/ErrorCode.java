package com.sparta.product.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, 40000, "입력값 유효성 검사에 실패하였습니다."),
    WRONG_PRODUCT(HttpStatus.BAD_REQUEST, 40001, "잘못된 상품 입니다."),
    DUPLICATE_REVIEW(HttpStatus.BAD_REQUEST,40002,"중복된 리뷰 입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 50000, "예상치 못한 오류가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}