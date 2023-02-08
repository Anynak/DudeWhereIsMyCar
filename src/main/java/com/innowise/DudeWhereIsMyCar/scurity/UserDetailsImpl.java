package com.innowise.DudeWhereIsMyCar.scurity;

import com.innowise.DudeWhereIsMyCar.model.Role;
import com.innowise.DudeWhereIsMyCar.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDetailsImpl implements UserDetails {

    public UserDetailsImpl(User user) {
        this.login = user.getLogin();
        this.passwordHash = user.getPasswordHash();
        this.isDeleted = user.getIsDeleted();
        this.authority = mapRolesToAuthorities(user.getRoles());
    }

    private final String login;
    private final String passwordHash;
    private final Boolean isDeleted;
    private final Collection<GrantedAuthority> authority;

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

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
