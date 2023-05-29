package com.innowise.dude_where_is_my_car.configs.scurity;

import com.innowise.dude_where_is_my_car.models.User;
import com.innowise.dude_where_is_my_car.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserBuLogin(username);
        return new UserDetailsImpl(user);
    }
}
