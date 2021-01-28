package com.example.common.exception;

import com.example.common.constant.ErrorCode;
import com.example.common.util.MessageSourceUtil;

/**
 * 业务异常
 *
 * @author Jack
 * @date 2020/04/25
 */
public class BusinessException extends RuntimeException {

    private ErrorCode code;

    public BusinessException() {
        super(MessageSourceUtil.getMessage(ErrorCode.INTERNAL_SERVER_ERROR.getDesc()));
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(String message) {
        super(message);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(Throwable cause) {
        super(cause.getMessage(), cause);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(ErrorCode code) {
        super(MessageSourceUtil.getMessage(code.getDesc()));
        this.code = code;
    }

    public BusinessException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCode getErrorCode() {
        return code;
    }

    public void setErrorCode(ErrorCode code) {
        this.code = code;
    }

}

