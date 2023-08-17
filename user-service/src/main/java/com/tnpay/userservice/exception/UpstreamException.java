package com.tnpay.userservice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UpstreamException extends RuntimeException {
    private final String message;

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public UpstreamException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
