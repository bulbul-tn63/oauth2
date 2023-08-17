package com.tnpay.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2ResourceServer ->
                        oauth2ResourceServer
                                .jwt(jwt ->
                                        jwt.jwkSetUri("http://localhost:8080/oauth2/jwks")
                                )
                                .opaqueToken(opaqueToken ->
                                        opaqueToken.introspectionUri("http://localhost:8080/oauth2/introspect")
                                                .introspectionClientCredentials("app", "secret")
                                )
                );

        return http.build();
    }

}
