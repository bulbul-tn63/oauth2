package com.tnpay.userservice.exception;



import com.tnpay.userservice.constant.ApplicationConstant;
import com.tnpay.userservice.constant.ErrorId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;
import java.util.Set;


import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;
import static org.apache.logging.log4j.util.Chars.SPACE;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError();
        PsoError engineeringManagementError =
                new PsoError(ErrorId.SYSTEM_ERROR, ex.getLocalizedMessage());
        apiError.addError(engineeringManagementError);
        ex.printStackTrace();
        return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object>
    handleConstraintViolationExceptionAllException(ConstraintViolationException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        violations.forEach(violation -> {
            PsoError reservationError = getEngineeringManagementError(violation.getMessageTemplate());
            apiError.addError(reservationError);
        });
        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PsoServerException.class)
    public final ResponseEntity<Object> handleEngineeringManagementServerException(
            PsoServerException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        PsoError reservationError = getEngineeringManagementError(ex.getErrorId());
        apiError.addError(reservationError);
        return new ResponseEntity(apiError, ex.getStatus());
    }



    private PsoError getEngineeringManagementError(String code) {
        PsoError engineeringManagementError = ErrorCodeReader.getPsoError(code);
        if (Objects.isNull(engineeringManagementError)) {
            return ErrorCodeReader.getErrorByMessage(code);
        }
        return engineeringManagementError;
    }

    private PsoError getEngineeringManagementError(String code, String message) {
        PsoError engineeringManagementError = ErrorCodeReader.getPsoError(code);
        if (Objects.isNull(engineeringManagementError)) {
            return ErrorCodeReader.getErrorByMessage(message);
        }
        return engineeringManagementError;
    }


    private String emptyFieldErrorIfNull(FieldError fieldError) {
        return Objects.isNull(fieldError) ? ApplicationConstant.EMPTY_STRING : fieldError.getField();
    }
}
