package com.vd.vd.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vd.vd.entity.Login;
import com.vd.vd.repository.LoginRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findById(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " tidak ditemukan"));
        return UserDetailsImpl.build(login);
    }
    
}
