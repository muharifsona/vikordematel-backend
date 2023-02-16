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

import com.vd.vd.service.KriteriaService;
import com.vd.vd.entity.Kriteria;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated()")
public class KriteriaController {
    @Autowired
    private KriteriaService kriteriaService;

    @GetMapping("/kriteria")
    public List<Kriteria> findAll() {
        return kriteriaService.findAll();
    }

    @GetMapping("/kriteria/{id}") 
    public Kriteria findById(@PathVariable("id") String id) {
        return kriteriaService.findById(id);
    }

    @PostMapping("/kriteria") 
    public Kriteria create(@RequestBody Kriteria kriteria) {
        return kriteriaService.create(kriteria);
    }

    @PutMapping("/kriteria") 
    public Kriteria edit(@RequestBody Kriteria kriteria) {
        return kriteriaService.edit(kriteria);
    }

    @DeleteMapping("/kriteria/{id}")
    public void deleteById(@PathVariable("id") String id) {
        kriteriaService.deleteById(id);
    }
}
