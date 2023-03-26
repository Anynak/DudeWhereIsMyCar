package com.innowise.DudeWhereIsMyCar.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    Authentication authenticate(String login, String password);
}
