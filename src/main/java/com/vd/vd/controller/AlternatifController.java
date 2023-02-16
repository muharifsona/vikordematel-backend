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

import com.vd.vd.service.AlternatifService;
import com.vd.vd.entity.Alternatif;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated()")
public class AlternatifController {
    @Autowired
    private AlternatifService alternatifService;

    @GetMapping("/alternatif")
    public List<Alternatif> findAll() {
        return alternatifService.findAll();
    }

    @GetMapping("/alternatif/{id}") 
    public Alternatif findById(@PathVariable("id") String id) {
        return alternatifService.findById(id);
    }

    @PostMapping("/alternatif") 
    public Alternatif create(@RequestBody Alternatif alternatif) {
        return alternatifService.create(alternatif);
    }

    @PutMapping("/alternatif") 
    public Alternatif edit(@RequestBody Alternatif alternatif) {
        return alternatifService.edit(alternatif);
    }

    @DeleteMapping("/alternatif/{id}")
    public void deleteById(@PathVariable("id") String id) {
        alternatifService.deleteById(id);
    }
}
