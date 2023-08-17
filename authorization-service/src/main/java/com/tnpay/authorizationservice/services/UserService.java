package com.tnpay.authorizationservice.services;

import com.tnpay.authorizationservice.config.SecurityUser;
import com.tnpay.authorizationservice.dto.UserDTO;
import com.tnpay.authorizationservice.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final UserDTO user = this.userFeignClient.getUserByUsername(username).getBody();

        if (Objects.isNull(user))
            throw new IllegalArgumentException("user not found");

        LOGGER.info("user [ {} ] found", user);
        return new SecurityUser(user);
    }

}
