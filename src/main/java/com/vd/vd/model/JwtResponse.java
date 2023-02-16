package com.vd.vd.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {
    private String token;
    private String refreshToken;
    private String type = "Bearer";
    private String username;
    private String nama;
    private String role;

    public JwtResponse(
        String accessToken,
        String refreshToken,
        String username, 
        String nama, 
        String role) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.username = username;
        this.nama = nama;
        this.role = role;
    }
    
    
}
