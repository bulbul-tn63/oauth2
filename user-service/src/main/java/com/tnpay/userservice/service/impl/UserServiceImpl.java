package com.tnpay.userservice.service.impl;

import com.tnpay.userservice.constant.ErrorId;
import com.tnpay.userservice.entity.Role;
import com.tnpay.userservice.entity.User;
import com.tnpay.userservice.exception.PsoServerException;
import com.tnpay.userservice.repository.UserRepository;
import com.tnpay.userservice.request.UserPayload;
import com.tnpay.userservice.service.RoleService;
import com.tnpay.userservice.service.UserService;
import com.tnpay.userservice.util.StringUtil;
import jakarta.ws.rs.NotFoundException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    private final RoleService roleService;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * Parameterized constructor
     *
     * @param userRepository {@link UserRepository}
     * @param encoder        {@link PasswordEncoder}
     * @param roleService
     */

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    @Override
    public User findByUsername(String username) {
        if(StringUtils.isBlank(username)){
            throw new RuntimeException("Username is required");
        }
        return userRepository.findByUsernameAndIsActiveTrue(username);
    }

    @Override
    public User findById(Long id) {
        return null;
    }


    @Override
    public User createUser(UserPayload userPayload) {
        validateRoleId(userPayload.getRole());
        return registerUser(userPayload);
    }

    @Override
    public User findUserById(Long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(()->new NotFoundException("User not found!!!"));
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository
                .findByEmail(email).orElseThrow(()->new NotFoundException("User not found!!"));
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository
                .findByUsername(username).orElseThrow(()->new NotFoundException("User not found!!"));
    }

    private User registerUser(UserPayload userPayload) {
        User user = userRepository.save(prepareUser(userPayload));
                Collections.singletonList(user.getEmail());
        return user;
    }

    private User prepareUser(UserPayload userPayload) {
        if (isUserExistsByName(userPayload)) {
            throw PsoServerException.badRequest(ErrorId.USER_EXISTS_WITH_THIS_NAME);
        }
        User user = new User();
        convertToUserFromPayload(user, userPayload);
        user.setPassword(encoder.encode(userPayload.getPassword()));
        return user;
    }

    private User convertToUserFromPayload(User user, UserPayload userPayload) {

        Set<Role> roleSet = new HashSet<>();
        user.setUsername(userPayload.getUsername());
        user.setEmail(userPayload.getEmail());
        if(Objects.nonNull(userPayload.getRole())){
            roleSet.add(roleService.findByName(userPayload.getRole()));
        }else{
            roleSet.add(roleService.findByName("USER"));
        }
        user.setRoles(roleSet);
        return user;
    }

    private void validateRoleId(String roleName) {
        //TODO: validation code for user register
    }

    private boolean isUserExistsByName(UserPayload userPayload) {
        return userRepository.findByUsername(userPayload.getUsername()).isPresent();
    }


}
