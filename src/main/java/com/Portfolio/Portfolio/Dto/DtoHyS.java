package com.Portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHyS {

    @NotBlank
    private String nombreS;
    @NotBlank
    private int porcentaje;
    private String color;
    
    //contructor

    public DtoHyS() {
    }

    public DtoHyS(String nombreS, int porcentaje, String color) {
        this.nombreS = nombreS;
        this.porcentaje = porcentaje;
        this.color = color;
    }
    
    //getter setter

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

  
    
    
    
    
}
