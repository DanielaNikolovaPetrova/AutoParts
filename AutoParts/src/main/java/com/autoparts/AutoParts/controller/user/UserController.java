package com.autoparts.AutoParts.controller.user;

import com.autoparts.AutoParts.dto.user.UserRequest;
import com.autoparts.AutoParts.entity.user.User;
import com.autoparts.AutoParts.security.AuthResponse;
import com.autoparts.AutoParts.security.LoginRequest;
import com.autoparts.AutoParts.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRequest request){
        User user = service.addUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@Valid @RequestBody LoginRequest request){
        return null;
    }
}
