package com.tnpay.authorizationservice.feign;


import com.tnpay.authorizationservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// name = spring.application.name
@FeignClient(name = "user-service", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    ResponseEntity<UserDTO> getUserByUsername(@RequestParam(name = "username") final String username);

}
