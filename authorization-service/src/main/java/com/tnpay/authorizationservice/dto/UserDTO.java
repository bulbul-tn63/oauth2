package com.tnpay.authorizationservice.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = {"id"})
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String password;

    @Setter(value = AccessLevel.NONE)
    Set<RoleDTO> roles = new HashSet<>();

}
