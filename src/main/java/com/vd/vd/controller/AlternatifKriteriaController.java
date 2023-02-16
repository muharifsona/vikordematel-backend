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

import com.vd.vd.service.AlternatifKriteriaService;
import com.vd.vd.entity.AlternatifKriteria;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated()")
public class AlternatifKriteriaController {
    @Autowired
    private AlternatifKriteriaService alternatifKriteriaService;

    @GetMapping("/alternatifkriteria")
    public List<AlternatifKriteria> findAll() {
        return alternatifKriteriaService.findAll();
    }

    @GetMapping("/alternatifkriteria/{id}") 
    public AlternatifKriteria findById(@PathVariable("id") String id) {
        return alternatifKriteriaService.findById(id);
    }

    @PostMapping("/alternatifkriteria") 
    public AlternatifKriteria create(@RequestBody AlternatifKriteria alternatifKriteria) {
        return alternatifKriteriaService.create(alternatifKriteria);
    }

    @PutMapping("/alternatifkriteria") 
    public AlternatifKriteria edit(@RequestBody AlternatifKriteria alternatifKriteria) {
        return alternatifKriteriaService.edit(alternatifKriteria);
    }

    @DeleteMapping("/alternatifkriteria/{id}")
    public void deleteById(@PathVariable("id") String id) {
        alternatifKriteriaService.deleteById(id);
    }
}
