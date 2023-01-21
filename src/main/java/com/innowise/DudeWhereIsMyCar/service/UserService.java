package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.dto.request.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.entity.User;

public interface UserService {
    User findUserBuLogin(String login);
    User registerUser(RegisterUserRequest userRequest);
}
