package com.example.carparkingmanagementbe.security;


import com.example.carparkingmanagementbe.security.userprinciple.AccountPrinciple;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private String jwtSecret = "c1021g1";
    private int jwtExpiration = 86400000;
    public String createToken(Authentication authentication){
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        String token = Jwts.builder().setSubject(accountPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
        return token;
    }
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public String getEmailFromToken(String token){
        String email = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return email;
    }
}
