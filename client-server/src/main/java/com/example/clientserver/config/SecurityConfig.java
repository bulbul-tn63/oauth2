package com.example.clientserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http.oauth2ResourceServer(
//        c -> c.jwt(
//            j -> j.jwkSetUri("http://localhost:8080/oauth2/jwks")
//        )
//    );
//    http.oauth2ResourceServer(
//        c -> c.opaqueToken(
//            o -> o.introspectionUri("http://localhost:8080/oauth2/introspect")
//                .introspectionClientCredentials("app", "secret")
//        )
//    );
//
//    http.authorizeHttpRequests(
//      c -> c.anyRequest().authenticated()
//    );
//
//    return http.build();
//  }


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.oauth2ResourceServer(
            c -> c.jwt(
                j -> j.jwkSetUri("http://localhost:8080/oauth2/jwks")
            )
          );

            http.authorizeHttpRequests(auth->{
              auth.requestMatchers("/user/auth").permitAll()
                      .requestMatchers("/**").authenticated();
            });

        return http.build();

  }



}
