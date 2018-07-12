package com.bilal.catZone.services;

import com.bilal.catZone.models.Role;
import com.bilal.catZone.models.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl /*implements UserDetails */{

  /*  private User user;
    private Role role;

    public UserDetailsImpl(User aUser, Role role) {
        this.user = aUser;
        this.role = role;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        /*for(Role role : user.getRoles()){
            authorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        authorityList.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserEmail();
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
        return true;
    }*/
}
