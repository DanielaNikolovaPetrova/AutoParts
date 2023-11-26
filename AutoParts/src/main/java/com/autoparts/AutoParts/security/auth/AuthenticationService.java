package com.autoparts.AutoParts.security.auth;

import com.autoparts.AutoParts.dto.user.UserRequest;
import com.autoparts.AutoParts.entity.user.User;
import com.autoparts.AutoParts.repository.user.UserRepository;
import com.autoparts.AutoParts.security.AuthResponse;
import com.autoparts.AutoParts.security.LoginRequest;
import com.autoparts.AutoParts.security.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager manager;

    public AuthResponse register(UserRequest request){

        var user = User.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .userRole(request.getUserRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse login (LoginRequest request){
        manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        var user = repository.findByUsername(request.getUsername()).orElseThrow(
                ()-> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
