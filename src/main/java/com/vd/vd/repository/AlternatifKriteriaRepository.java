package com.vd.vd.repository;

import java.util.Optional;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vd.vd.entity.AlternatifKriteria;

public interface AlternatifKriteriaRepository extends JpaRepository<AlternatifKriteria, String> {

    Optional<AlternatifKriteria> findByAlternatifIdAndKriteriaId(String id, String id2);
    
}
