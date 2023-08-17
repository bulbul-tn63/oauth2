package com.tnpay.userservice.repository;


import com.tnpay.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

    User findByUsernameAndIsActiveTrue(String username);

  Optional<User>  findByEmail(String email);
}
