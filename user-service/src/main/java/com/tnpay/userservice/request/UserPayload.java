package com.tnpay.userservice.request;

import com.tnpay.userservice.constant.ApplicationConstant;
import com.tnpay.userservice.constant.ErrorId;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPayload {
    @Size(min = 3, max = 20, message = ErrorId.INVALID_LOGIN_SIZE)
    @NotBlank
    private String username;

    private String role;
    @Email(regexp = ApplicationConstant.EMAIL_VALIDATION_REGEX, message = ErrorId.INVALID_EMAIL_PATTERN)
    private String email;
    private String password;
}
