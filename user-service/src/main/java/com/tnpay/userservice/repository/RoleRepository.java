package com.tnpay.userservice.repository;

import com.tnpay.userservice.constant.ERole;
import com.tnpay.userservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Optional<Role> findByIdAndIsActiveTrue(Integer id);

    Optional<Role> findByRoleNameAndIsActiveTrue(String name);
}
