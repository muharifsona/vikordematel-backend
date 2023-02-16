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

import com.vd.vd.service.PerbandinganService;
import com.vd.vd.entity.Perbandingan;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated()")
public class PerbandinganController {
    @Autowired
    private PerbandinganService perbandinganService;

    @GetMapping("/perbandingan")
    public List<Perbandingan> findAll() {
        return perbandinganService.findAll();
    }

    @GetMapping("/perbandingan/{id_perbandingan}") 
    public Perbandingan findById(@PathVariable("id_perbandingan") String id_perbandingan) {
        return perbandinganService.findById(id_perbandingan);
    }

    @PostMapping("/perbandingan") 
    public Perbandingan create(@RequestBody Perbandingan perbandingan) {
        return perbandinganService.create(perbandingan);
    }

    @PutMapping("/perbandingan") 
    public Perbandingan edit(@RequestBody Perbandingan perbandingan) {
        return perbandinganService.edit(perbandingan);
    }

    @DeleteMapping("/perbandingan/{id_perbandingan}")
    public void deleteById(@PathVariable("id_perbandingan") String id_perbandingan) {
        perbandinganService.deleteById(id_perbandingan);
    }
}
