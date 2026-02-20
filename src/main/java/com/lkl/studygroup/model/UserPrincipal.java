package com.lkl.studygroup.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class UserPrincipal implements UserDetails {
    User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // MODIFIED: Return User ID instead of empty string or username
        // This is CRITICAL for WebSocket routing (convertAndSendToUser uses this
        // Principal name)
        return user.getId().toString();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getJwtTokenId() {
        return user.getJwtTokenId();
    }

    public UUID getUserId() {
        return user.getId();
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
        // MODIFIED: Block login if account is deactivated
        return !Boolean.TRUE.equals(user.getIsDeactivated());
    }
}
