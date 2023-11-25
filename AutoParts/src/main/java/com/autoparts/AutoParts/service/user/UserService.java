package com.autoparts.AutoParts.service.user;

import com.autoparts.AutoParts.dto.user.UserRequest;
import com.autoparts.AutoParts.entity.user.User;

public interface UserService {
    User addUser(UserRequest request);
}
