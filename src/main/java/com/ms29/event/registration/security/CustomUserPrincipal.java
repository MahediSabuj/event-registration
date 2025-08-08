package com.ms29.event.registration.security;

import com.ms29.event.registration.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomUserPrincipal implements UserDetails {
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().getUserRoleName()));
    }

    @Override
    public String getUsername() {
        return user.getEmailAddress();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // Additional methods to access user data
    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

    public Integer getId() {
        return user.getId();
    }
}