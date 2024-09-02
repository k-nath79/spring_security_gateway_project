package com.ust.IdentityService.IdentityService.service;

import com.ust.IdentityService.IdentityService.model.CustomUserDetails;
import com.ust.IdentityService.IdentityService.model.UserCredential;
import com.ust.IdentityService.IdentityService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredential> userCredential = userRepo.findByUserName(username) ;
        return userCredential.map(CustomUserDetails::new).orElseThrow(()->new RuntimeException("Username not found"));
    }
}
