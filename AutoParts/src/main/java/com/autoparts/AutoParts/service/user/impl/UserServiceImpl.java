package com.autoparts.AutoParts.service.user.impl;

import com.autoparts.AutoParts.dto.user.UserRequest;
import com.autoparts.AutoParts.entity.user.User;
import com.autoparts.AutoParts.repository.user.UserRepository;
import com.autoparts.AutoParts.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(UserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setUserRole(request.getUserRole());
        return repository.save(user);
    }
}
