package com.ust.IdentityService.IdentityService.controller;

import com.ust.IdentityService.IdentityService.dto.TokenDto;
import com.ust.IdentityService.IdentityService.model.UserCredential;
import com.ust.IdentityService.IdentityService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserCredential user){
        return authService.registerUser(user);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody UserCredential user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(authentication.isAuthenticated()){
        return authService.generateToken(user.getUserName());
        }else {
            throw new RuntimeException("Invalid Token");
        }

    }

    @PostMapping("/validate")
    public String validateUser(@RequestParam("token") String token){
        return authService.validateUser(token);
    }


}
