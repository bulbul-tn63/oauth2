package com.tnpay.userservice.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PsoError {
    private String code;
    private String message;

    public PsoError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
