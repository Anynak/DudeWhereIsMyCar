package com.innowise.DudeWhereIsMyCar.configs.scurity;

import com.innowise.DudeWhereIsMyCar.models.User;
import com.innowise.DudeWhereIsMyCar.service.UserService;
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
