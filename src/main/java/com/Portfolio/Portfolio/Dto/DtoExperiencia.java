package com.Portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String nombreE2;
    @NotBlank
    private String descripcionE;

    //contructor
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String nombreE2, String descripcionE) {
        this.nombreE = nombreE;
        this.nombreE2 = nombreE2;
        this.descripcionE = descripcionE;
    }

    //getter setter

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
