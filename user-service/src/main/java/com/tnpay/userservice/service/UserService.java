package com.tnpay.userservice.service;

import com.tnpay.userservice.entity.BaseEntity;
import com.tnpay.userservice.entity.User;
import com.tnpay.userservice.request.UserPayload;

public interface UserService {

    User findByUsername(String login);

    User findById(Long id);


    User createUser(UserPayload userPayload);

    User findUserById(Long userId);

    User findUserByEmail(String email);

    User findUserByUsername(String username);
}
