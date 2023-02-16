package com.vd.vd.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.vd.entity.Perbandingan;
import com.vd.vd.exception.ResourceNotFoundException;
import com.vd.vd.repository.PerbandinganRepository;

@Service 
public class PerbandinganService {
    
    @Autowired
    private PerbandinganRepository perbandinganRepository;

    public Perbandingan findById(String id_perbandingan) {
        return perbandinganRepository.findById(id_perbandingan).orElseThrow(() -> new ResourceNotFoundException("Data Perbandingan dengan id "+id_perbandingan+" tidak ditemukan"));

    }

    public List<Perbandingan> findAll() {
        return perbandinganRepository.findAll();
    }

    public Perbandingan create(Perbandingan perbandingan) {
        perbandingan.setId_perbandingan(perbandingan.getId_perbandingan().toString());
        // perbandingan.setId_perbandingan(UUID.randomUUID().toString());
        return perbandinganRepository.save(perbandingan);
    }

    public Perbandingan edit(Perbandingan perbandingan) {
        return perbandinganRepository.save(perbandingan);
    }

    public void deleteById(String id_perbandingan) {
        perbandinganRepository.deleteById(id_perbandingan);
    }

}
