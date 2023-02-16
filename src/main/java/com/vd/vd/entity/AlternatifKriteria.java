package com.vd.vd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class AlternatifKriteria implements Serializable {
    @Id
    @Column(name = "id_alternatif_kriteria")
    private String id;
    @JoinColumn(name = "id_alternatif")
    @ManyToOne
    private Alternatif alternatif;
    @JoinColumn(name = "id_kriteria")
    @ManyToOne
    private Kriteria kriteria;
    // private String id_kriteria;
    // private String id_alternatif;
    private String nilai;

}
