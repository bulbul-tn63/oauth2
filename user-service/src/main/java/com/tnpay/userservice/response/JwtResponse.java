package com.tnpay.userservice.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String refreshToken;
    private String type = "Bearer";
    private Long id;
    private String username;
    private List<String> roles;
    private Map<String, Integer> userAccessPermissions;
//    private List<ModuleViewModel> moduleViewModelList;
//    private FeatureRoleViewModel featureRoleViewModel;

    public JwtResponse(String accessToken,
                       String refreshToken,
                       Long id,
                       String username,
                       List<String> roles
                       ) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.userAccessPermissions = userAccessPermissions;

    }
}
