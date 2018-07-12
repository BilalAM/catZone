package com.bilal.catZone.services;

import com.bilal.catZone.models.Owner;
import com.bilal.catZone.models.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OwnerDetailsImpl implements UserDetails {


    private Owner owner;
    private Role role;

    public OwnerDetailsImpl(Owner owner, Role role) {
        this.owner = owner;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(owner.getRole().getRoleName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return owner.getOwnerPassword();
    }

    @Override
    public String getUsername() {
        return owner.getOwnerEmail();
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
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
