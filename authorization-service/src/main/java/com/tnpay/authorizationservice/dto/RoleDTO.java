package com.tnpay.authorizationservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = {"id", "roleName"})
public class RoleDTO {

    private Long id;
    private String roleName;

}
