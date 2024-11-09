package com.taskmanager.taskmanagementsystem.controller;

import com.taskmanager.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    /**
     * Endpoint para el inicio de sesión.
     * Recibe el nombre de usuario y la contraseña, y devuelve un token JWT si la autenticación es exitosa.
     *
     * @param username El nombre de usuario del usuario que quiere autenticarse.
     * @param password La contraseña del usuario.
     * @return Un token JWT que el cliente debe usar para autenticar las solicitudes futuras.
     */
    @PostMapping("/login")
    public String authenticateUser(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        User user = (User) authentication.getPrincipal();

        return tokenProvider.generateToken(user.getUsername());
    }
}