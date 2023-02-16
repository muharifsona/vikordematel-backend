package com.vd.vd.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Login implements Serializable {
    @Id
    private String username;
    // @JsonIgnore
    private String password;
    private String nama;
    // @JsonIgnore
    private String role;
    
}
