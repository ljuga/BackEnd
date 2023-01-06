package com.Portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHySB {

    @NotBlank
    private String nombreB;
    @NotBlank
    private int porcentajeB;
    private int colorB;

    //constructor
    public DtoHySB() {
    }

    public DtoHySB(String nombreB, int porcentajeB, int colorB) {
        this.nombreB = nombreB;
        this.porcentajeB = porcentajeB;
        this.colorB = colorB;
    }

    //getter setter

    public String getNombreB() {
        return nombreB;
    }

    public void setNombreB(String nombreB) {
        this.nombreB = nombreB;
    }

    public int getPorcentajeB() {
        return porcentajeB;
    }

    public void setPorcentajeB(int porcentajeB) {
        this.porcentajeB = porcentajeB;
    }

    public int getColorB() {
        return colorB;
    }

    public void setColorB(int colorB) {
        this.colorB = colorB;
    }
    
    
    
}
