package com.vd.vd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vd.vd.model.JwtResponse;
import com.vd.vd.model.LoginRequest;
import com.vd.vd.model.RefreshTokenRequest;
import com.vd.vd.security.jwt.JwtUtils;
import com.vd.vd.security.service.UserDetailsImpl;
import com.vd.vd.security.service.UserDetailsServiceImpl;
import com.vd.vd.service.LoginService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    LoginService loginService; 
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        String refreshToken = jwtUtils.generateRefreshJwtToken(authentication);
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok().body(new JwtResponse(token, refreshToken, principal.getUsername(), principal.getNama(), principal.getRole()));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<JwtResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        String token = request.getRefreshToken();
        boolean valid = jwtUtils.validateJwtToken(token);
        if (!valid) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        String username = jwtUtils.getUserNameFromJwtToken(token);
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetailsServiceImpl.loadUserByUsername(username);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetailsImpl, null, userDetailsImpl.getAuthorities());
        String newToken = jwtUtils.generateJwtToken(authentication);
        String refreshToken = jwtUtils.generateRefreshJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(newToken, refreshToken, username, userDetailsImpl.getNama(), userDetailsImpl.getRole()));
    }

}
