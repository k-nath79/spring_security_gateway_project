package com.ust.IdentityService.IdentityService.controller;

import com.ust.IdentityService.IdentityService.dto.TokenDto;
import com.ust.IdentityService.IdentityService.model.UserCredential;
import com.ust.IdentityService.IdentityService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserCredential user){
        return authService.registerUser(user);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody UserCredential user){
        return authService.generateToken(user.getUserName());
    }

    @PostMapping("/validate")
    public String validateUser(@RequestBody TokenDto token1){
        return authService.validateUser(token1.token1());
    }


}
