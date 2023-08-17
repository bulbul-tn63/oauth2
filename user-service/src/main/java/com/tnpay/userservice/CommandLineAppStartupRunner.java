package com.tnpay.userservice;

import com.tnpay.userservice.repository.RoleRepository;
import com.tnpay.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

//        INSERT INTO roles (id,is_active, name)
//        VALUES
//                (1,1,'ROLE_SUPER_ADMIN');

        String pass = "1234";
        System.out.println(passwordEncoder.encode(pass));

    }
}
