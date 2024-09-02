package com.ust.IdentityService.IdentityService.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
    /*
    *Create token
    *Validate Token */
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    public String generateToken(String userName){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userName);
    }

    public String createToken(Map<String,Object> claims, String username){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(signKey(), SignatureAlgorithm.HS256).compact();
    }

    public void validateToken(String token){
        Jwts.parserBuilder().setSigningKey(signKey()).build().parseClaimsJwt(token);
    }

    public Key signKey(){
        byte[] byteKey = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(byteKey);
    }
}


