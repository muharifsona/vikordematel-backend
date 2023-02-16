package com.vd.vd.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vd.vd.entity.Kriteria;
import com.vd.vd.exception.ResourceNotFoundException;
import com.vd.vd.repository.KriteriaRepository;

@Service 
public class KriteriaService {
    
    @Autowired
    private KriteriaRepository kriteriaRepository;

    public Kriteria findById(String id) {
        return kriteriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kriteria dengan id "+id+" tidak ditemukan"));
    }

    public List<Kriteria> findAll() {
        return kriteriaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Kriteria create(Kriteria kriteria) {
        kriteria.setId(UUID.randomUUID().toString());
        return kriteriaRepository.save(kriteria);
    }

    public Kriteria edit(Kriteria kriteria) {
        return kriteriaRepository.save(kriteria);
    }

    public void deleteById(String id) {
        kriteriaRepository.deleteById(id);
    }

}
