package com.vd.vd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Kriteria implements Serializable {
    @Id
    @Column(name = "id_kriteria")
    private String id;
    private String nama_kriteria;
    private String costbenefit;
    private String bobot_kriteria;

}
