package com.vd.vd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vd.vd.entity.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
    
}
