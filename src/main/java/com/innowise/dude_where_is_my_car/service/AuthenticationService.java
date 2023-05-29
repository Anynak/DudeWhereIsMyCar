package com.innowise.dude_where_is_my_car.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    Authentication authenticate(String login, String password);
}
