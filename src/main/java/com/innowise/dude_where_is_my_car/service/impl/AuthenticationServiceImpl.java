package com.innowise.dude_where_is_my_car.service.impl;

import com.innowise.dude_where_is_my_car.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication authenticate(String login, String password) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login, password));
    }
}
