package com.example.jwt_application.service;

import com.example.jwt_application.model.User;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTService {

    public String generateToken(String username) {
        Map<String, Object>claims = new HashMap<>();
        return "Test";
//        return Jwts
//                .builder()
//                .claims()
//                .add(claims)
//                .subject(username)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() * 60 * 60 * 30))

    }
}
