package com.tnpay.userservice.controller;


import com.tnpay.userservice.entity.User;
import com.tnpay.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String welcome(){
        return "Welcome to TN-PAY USER-SERVICE";
    }

    @GetMapping(value = "/{user_id}")
    public ResponseEntity<User> findUserById(@PathVariable(name = "user_id") final Long userId) {
        final User user = this.userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search/email")
    public ResponseEntity<User> findUserByEmail(@RequestParam(name = "email") final String email) {
        final User user = this.userService.findUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findUserByUsername(@RequestParam(name = "username") final String username) {
        final User user = this.userService.findUserByUsername(username);
        return ResponseEntity.ok(user);
    }

}
