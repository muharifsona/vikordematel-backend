package com.vd.vd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vd.vd.service.LoginService;
import com.vd.vd.entity.Login;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated()")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public List<Login> findAll() {
        return loginService.findAll();
    }

    @GetMapping("/login/{id}") 
    public Login findById(@PathVariable("id") String id) {
        return loginService.findById(id);
    }

    @PostMapping("/login") 
    public Login create(@RequestBody Login login) {
        return loginService.create(login);
    }

    @PutMapping("/login") 
    public Login edit(@RequestBody Login login) {
        return loginService.edit(login);
    }

    @DeleteMapping("/login/{username}")
    public void deleteById(@PathVariable("username") String id) {
        loginService.deleteById(id);
    }
}
