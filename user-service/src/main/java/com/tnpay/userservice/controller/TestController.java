package com.tnpay.userservice.controller;

import com.tnpay.userservice.entity.User;
import com.tnpay.userservice.request.UserPayload;
import com.tnpay.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class TestController {

    @Autowired
    private UserService userService;
    @GetMapping
    public String HelloUser(){
        return "Hello TechnoNext Pay";
    }

    @PostMapping("/register")
    public User create(@RequestBody UserPayload userPayload){
        return userService.createUser(userPayload);
    }
}
