package com.Portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String nombreE2;
    @NotBlank
    private String descripcionE;

    private String imgE;

    //contructor
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String nombreE2, String descripcionE, String imgE) {
        this.nombreE = nombreE;
        this.nombreE2 = nombreE2;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
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

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }
    
    
}
