package com.vd.vd.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.vd.entity.Alternatif;
import com.vd.vd.exception.ResourceNotFoundException;
import com.vd.vd.repository.AlternatifRepository;

@Service 
public class AlternatifService {
    
    @Autowired
    private AlternatifRepository alternatifRepository;

    public Alternatif findById(String id) {
        return alternatifRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Alternatif dengan id "+id+" tidak ditemukan"));

    }

    public List<Alternatif> findAll() {
        return alternatifRepository.findAll();
    }

    public Alternatif create(Alternatif alternatif) {
        alternatif.setId(UUID.randomUUID().toString());
        return alternatifRepository.save(alternatif);
    }

    public Alternatif edit(Alternatif alternatif) {
        return alternatifRepository.save(alternatif);
    }

    public void deleteById(String id) {
        alternatifRepository.deleteById(id);
    }

}
