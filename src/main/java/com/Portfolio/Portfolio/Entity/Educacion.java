package com.Portfolio.Portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreED;
    private String nombreED2;
    private String descripcionED;
    private String imgED;

    //constructores
    public Educacion() {
    }

    public Educacion(String nombreED, String nombreED2, String descripcionED, String imgED) {
        this.nombreED = nombreED;
        this.nombreED2 = nombreED2;
        this.descripcionED = descripcionED;
        this.imgED = imgED;
    }

    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreED() {
        return nombreED;
    }

    public void setNombreED(String nombreED) {
        this.nombreED = nombreED;
    }

    public String getNombreED2() {
        return nombreED2;
    }

    public void setNombreED2(String nombreED2) {
        this.nombreED2 = nombreED2;
    }

    public String getDescripcionED() {
        return descripcionED;
    }

    public void setDescripcionED(String descripcionED) {
        this.descripcionED = descripcionED;
    }

    public String getImgED() {
        return imgED;
    }

    public void setImgED(String imgED) {
        this.imgED = imgED;
    }

}
