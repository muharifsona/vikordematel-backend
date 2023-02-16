package com.vd.vd.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.vd.entity.AlternatifKriteria;
import com.vd.vd.exception.ResourceNotFoundException;
import com.vd.vd.repository.AlternatifKriteriaRepository;

@Service 
public class AlternatifKriteriaService {
    
    @Autowired
    private AlternatifKriteriaRepository alternatifKriteriaRepository;

    public AlternatifKriteria findById(String id) {
        return alternatifKriteriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Alternatif Kriteria dengan id " + id + " tidak ditemukan"));
    }

    public List<AlternatifKriteria> findAll() {
        return alternatifKriteriaRepository.findAll();
    }

    public AlternatifKriteria create(AlternatifKriteria alternatifKriteria) {
        alternatifKriteria.setId(UUID.randomUUID().toString());
        return alternatifKriteriaRepository.save(alternatifKriteria);
    }

    public AlternatifKriteria edit(AlternatifKriteria alternatifKriteria) {
        return alternatifKriteriaRepository.save(alternatifKriteria);
    }

    public void deleteById(String id) {
        alternatifKriteriaRepository.deleteById(id);
    }

}
