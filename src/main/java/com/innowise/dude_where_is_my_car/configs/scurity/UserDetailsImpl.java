package com.innowise.dude_where_is_my_car.configs.scurity;

import com.innowise.dude_where_is_my_car.models.Role;
import com.innowise.dude_where_is_my_car.models.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class UserDetailsImpl implements UserDetails {

    private final String login;
    private final Long userId;
    private final String passwordHash;
    private final Boolean isDeleted;
    private final Collection<? extends GrantedAuthority> authority;

    public UserDetailsImpl(User user) {
        this.login = user.getLogin();
        this.userId = user.getUserId();
        this.passwordHash = user.getPasswordHash();
        this.isDeleted = user.getIsDeleted();
        this.authority = mapRolesToAuthorities(user.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authority;
    }

    @Override
    public String getPassword() {
        return this.passwordHash;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.isDeleted;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).toList();
    }
}
