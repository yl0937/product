package com.sparta.product.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sparta.product.common.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonPropertyOrder({"ok", "code", "message", "detail"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private boolean ok = false;
    private int code;
    private String message;
    private String detail;

    protected ErrorResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.detail = null;
    }

    protected ErrorResponse(ErrorCode errorCode, String detail) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.detail = detail;
    }
}