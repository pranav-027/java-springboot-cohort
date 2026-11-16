package com.codingshuttle.securityApplication.controllers;

import com.codingshuttle.securityApplication.dtos.LoginDto;
import com.codingshuttle.securityApplication.dtos.SignUpDto;
import com.codingshuttle.securityApplication.dtos.UserDto;
import com.codingshuttle.securityApplication.services.impl.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto request) {
        return ResponseEntity.ok(authService.signUp(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto request, HttpServletResponse response) {


        String token = authService.login(request);
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
         // cookie.setSecure(true); --> only for https / prod
        response.addCookie(cookie);

        return ResponseEntity.ok(token);
    }
}