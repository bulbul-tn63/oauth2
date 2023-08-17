package com.tnpay.userservice.exception;

import com.tnpay.userservice.constant.ApplicationConstant;
import lombok.Data;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

@Data
public class PsoServerException extends RuntimeException {
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1436995162658277359L;
    /**
     * Error id.
     */
    private final String errorId;

    /**
     * trace id.
     */
    private final String traceId;

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    private String message;

    public PsoServerException(String errorId, HttpStatus status, String traceId) {
        this.errorId = errorId;
        this.traceId = traceId;
        this.status = status;
    }

    public PsoServerException(String errorId, HttpStatus status, String traceId, String message) {
        this.errorId = errorId;
        this.traceId = traceId;
        this.status = status;
        this.message = message;
    }

    public static PsoServerException badRequest(String errorId) {
        return new PsoServerException(errorId, HttpStatus.BAD_REQUEST, MDC.get(
                ApplicationConstant.TRACE_ID));
    }

    public static PsoServerException badRequest(String errorId, String message) {
        return new PsoServerException(errorId, HttpStatus.BAD_REQUEST, MDC.get(
                ApplicationConstant.TRACE_ID), message);
    }

    public static PsoServerException notFound(String errorId) {
        return new PsoServerException(errorId, HttpStatus.NOT_FOUND, MDC.get(
                ApplicationConstant.TRACE_ID));
    }

    public static PsoServerException dataSaveException(String errorId) {
        return new PsoServerException(errorId, HttpStatus.INTERNAL_SERVER_ERROR,
                MDC.get(ApplicationConstant.TRACE_ID));
    }

    public static PsoServerException internalServerException(String errorId) {
        return new PsoServerException(errorId, HttpStatus.INTERNAL_SERVER_ERROR,
                MDC.get(ApplicationConstant.TRACE_ID));
    }

    public static PsoServerException notAuthorized(String errorId) {
        return new PsoServerException(errorId, HttpStatus.FORBIDDEN,
                MDC.get(ApplicationConstant.TRACE_ID)
        );
    }
}
