package com.taskmanager.taskmanagementsystem.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")

public class AuthController {

    private final String jwtSecret = "your_secret_key_for_jwt"; // Clave secreta para el token
    private final long jwtExpirationMs = 86400000; // Duración del token en milisegundos (24 horas)

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserLoginRequest loginRequest) {
        Map<String, String> response = new HashMap<>();

        if (isValidUser(loginRequest)) {
            String token = Jwts.builder()
                    .setSubject(loginRequest.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                    .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                    .compact();

            response.put("token", token);
            response.put("status", "success");
        } else {
            response.put("status", "error");
            response.put("message", "Invalid credentials");
        }

        return response;
    }

    private boolean isValidUser(UserLoginRequest loginRequest) {
        return "usuario".equals(loginRequest.getUsername()) && "contraseña".equals(loginRequest.getPassword());
    }

    static class UserLoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}