package com.Portfolio.Portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String nombreE;
    private String nombreE2;
    private String descripcionE;
    
    //constructores

    public Experiencia() {
    }

    public Experiencia(String nombreE, String nombreE2, String descripcionE) {
        this.nombreE = nombreE;
        this.nombreE2 = nombreE2;
        this.descripcionE = descripcionE;
    }
    
    //Getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombreE2() {
        return nombreE2;
    }

    public void setNombreE2(String nombreE2) {
        this.nombreE2 = nombreE2;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
}
