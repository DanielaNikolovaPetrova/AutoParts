package com.autoparts.AutoParts.converter.user;

import com.autoparts.AutoParts.dto.user.UserRequest;
import com.autoparts.AutoParts.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User toUser(UserRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .userRole(request.getUserRole())
                .build();
        return user;
    }
}
