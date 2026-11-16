package com.codingshuttle.securityApplication.services.impl;

import com.codingshuttle.securityApplication.dtos.LoginDto;
import com.codingshuttle.securityApplication.dtos.SignUpDto;
import com.codingshuttle.securityApplication.dtos.UserDto;
import com.codingshuttle.securityApplication.entities.User;
import com.codingshuttle.securityApplication.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(JwtService jwtService, UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public UserDto signUp(SignUpDto request) {

        User user = userRepository.findByEmail(request.getEmail()).orElse(null);
        if (user != null) {
            throw new BadCredentialsException("User with email " + request.getEmail() + " already exists");
        }

       User toCreate = modelMapper.map(request, User.class);
       toCreate.setPassword(passwordEncoder.encode(request.getPassword()));
       User createdUser = userRepository.save(toCreate);

        return modelMapper.map(createdUser, UserDto.class);
    }

    public String login(LoginDto request) {
        Authentication authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(request.getEmail(), request.getPassword()));
        User user = (User) authentication.getPrincipal();
        if (!authentication.isAuthenticated() && user == null) {
            throw new BadCredentialsException("Invalid email or password");
        }
        assert user != null;
        return jwtService.generateToken(user);
    }
}
