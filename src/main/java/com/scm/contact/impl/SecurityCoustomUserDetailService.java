package com.scm.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.contact.entities.User;
import com.scm.contact.repositories.UserRepo;

@Service
public class SecurityCoustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepo userRepo;

 @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with " + username));

    return org.springframework.security.core.userdetails.User
        .withUsername(user.getEmail())
        .password(user.getPassword())
        .roles("USER") // or user.getRole() if you store roles
        .build();
}

}
