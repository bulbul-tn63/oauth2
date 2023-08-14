package com.example.oauth2.services;

import com.example.oauth2.model.SecurityUser;
import com.example.oauth2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    var user = userRepository.findUserByUsername(username);

    return user.map(SecurityUser::new)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
  }
}
