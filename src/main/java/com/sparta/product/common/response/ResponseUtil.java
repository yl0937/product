package com.sparta.product.common.response;

import com.sparta.product.common.exception.ErrorCode;

public class ResponseUtil {

    public static SuccessResponse<?> success() {
        return SuccessResponse.NO_DATA_RESPONSE;
    }

    public static <T> SuccessResponse<T> success(T data) {
        return new SuccessResponse<>(data);
    }

    public static ErrorResponse error(ErrorCode errorCode) {
        return new ErrorResponse(errorCode);
    }

    public static ErrorResponse error(ErrorCode errorCode, String detail) {
        return new ErrorResponse(errorCode, detail);
    }
}