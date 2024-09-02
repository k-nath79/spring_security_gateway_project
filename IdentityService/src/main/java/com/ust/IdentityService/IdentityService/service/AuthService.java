package com.ust.IdentityService.IdentityService.service;

import com.ust.IdentityService.IdentityService.model.UserCredential;
import com.ust.IdentityService.IdentityService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> registerUser(UserCredential user){
        Optional<UserCredential> olduser = userRepo.findByUserName(user.getUserName());

        if(olduser == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User already Exists");
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public String validateUser(String token1){
        jwtService.validateToken(token1);
        return "Valid";
    }
}
