package com.vd.vd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vd.vd.entity.Login;
import com.vd.vd.exception.BadRequestException;
import com.vd.vd.exception.ResourceNotFoundException;
import com.vd.vd.repository.LoginRepository;

@Service 
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Login findById(String id) {
        return loginRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Login dengan id "+id+" tidak ditemukan"));

    }

    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    public Login create(Login login) {
        if (loginRepository.existsById(login.getUsername())) {
            throw new BadRequestException("Username " + login.getUsername() + " sudah ada");
        }
        final String encodedPassword = passwordEncoder.encode(login.getPassword());
        login.setPassword(encodedPassword);
        return loginRepository.save(login);
    }

    public Login edit(Login login) {
        final String encodedPassword = passwordEncoder.encode(login.getPassword());
        login.setPassword(encodedPassword);
        return loginRepository.save(login);
    }

    public void deleteById(String id) {
        loginRepository.deleteById(id);
    }

}
