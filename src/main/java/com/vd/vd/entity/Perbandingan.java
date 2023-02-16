package com.vd.vd.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Perbandingan implements Serializable {
    @Id
    private String id_perbandingan;
    private String dematel_scale;

}
