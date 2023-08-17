package com.tnpay.userservice.service;


import com.tnpay.userservice.entity.Role;

public interface RoleService {
    Role findById(Integer roleId);
    Role findByName(String name);

}
