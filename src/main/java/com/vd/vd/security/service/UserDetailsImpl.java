package com.vd.vd.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vd.vd.entity.Login;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String nama;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String role;

    public UserDetailsImpl(
        String username, 
        String nama, 
        String password, 
        String role) {
        this.username = username;
        this.nama = nama;
        this.password = password;
        this.role = role;
    }

    public static UserDetailsImpl build(Login login) {
        return new UserDetailsImpl(
            login.getUsername(), 
            login.getNama(), 
            login.getPassword(), 
            login.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (StringUtils.hasText(role)) {
            String[] splits = role.replaceAll(" ", "").split(",");
            for (String string : splits) {
                authorities.add(new SimpleGrantedAuthority(string));
            }
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
