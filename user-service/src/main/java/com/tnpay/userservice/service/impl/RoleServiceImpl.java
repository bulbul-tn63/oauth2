package com.tnpay.userservice.service.impl;


import com.tnpay.userservice.constant.ErrorId;
import com.tnpay.userservice.entity.Role;
import com.tnpay.userservice.exception.PsoServerException;
import com.tnpay.userservice.repository.RoleRepository;
import com.tnpay.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Integer id) {
        if (Objects.isNull(id)) {
            throw PsoServerException
                    .internalServerException(ErrorId.ID_IS_REQUIRED);
        }
        return roleRepository.findByIdAndIsActiveTrue(id).orElseThrow(() -> {
            throw PsoServerException
                    .internalServerException(ErrorId.INVALID_ROLE);
        });
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByRoleNameAndIsActiveTrue(name).orElseThrow(() -> {
            throw PsoServerException
                    .internalServerException(ErrorId.INVALID_ROLE);
        });
    }
}
