package com.codingshuttle.securityApplication.controllers;

import com.codingshuttle.securityApplication.dtos.LoginDto;
import com.codingshuttle.securityApplication.dtos.LoginResponse;
import com.codingshuttle.securityApplication.dtos.SignUpDto;
import com.codingshuttle.securityApplication.dtos.UserDto;
import com.codingshuttle.securityApplication.services.impl.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto request, HttpServletResponse response) {


        LoginResponse loginResponse = authService.login(request);

        Cookie cookie = new Cookie("refreshToken", loginResponse.getRefreshToken());
        cookie.setHttpOnly(true);
         // cookie.setSecure(true); --> only for https / prod
        response.addCookie(cookie);

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(HttpServletRequest request, HttpServletResponse response) {

        if (request.getCookies() == null) {
            throw new AuthenticationServiceException("Refresh token not found in cookies");
        }

        String refreshToken = Arrays.stream(request.getCookies())
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(() -> new AuthenticationServiceException("Refresh token not found in cookies"));

       return ResponseEntity.ok(authService.refreshToken(refreshToken));
    }

}