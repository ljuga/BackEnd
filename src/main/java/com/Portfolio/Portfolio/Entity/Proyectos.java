package com.Portfolio.Portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String nombrePT;
    private String descripcionP;
    private String nombreL;
    
    //contructor

    public Proyectos() {
    }

    public Proyectos(String nombreP, String nombrePT, String descripcionP, String nombreL) {
        this.nombreP = nombreP;
        this.nombrePT = nombrePT;
        this.descripcionP = descripcionP;
        this.nombreL = nombreL;
    }
    
    //getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getNombrePT() {
        return nombrePT;
    }

    public void setNombrePT(String nombrePT) {
        this.nombrePT = nombrePT;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getNombreL() {
        return nombreL;
    }

    public void setNombreL(String nombreL) {
        this.nombreL = nombreL;
    }
    
    
}
