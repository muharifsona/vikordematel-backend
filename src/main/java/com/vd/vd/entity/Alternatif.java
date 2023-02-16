package com.vd.vd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Alternatif implements Serializable {
    @Id
    @Column(name = "id_alternatif")
    private String id;
    private String nama_alternatif;
    private String deskripsi;

}
