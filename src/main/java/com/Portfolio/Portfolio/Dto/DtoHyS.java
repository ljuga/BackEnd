package com.Portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHyS {

    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    private int color;
    
    //contructor

    public DtoHyS() {
    }

    public DtoHyS(String nombre, int porcentaje, int color) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.color = color;
    }
    
    //getter setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

  
    
    
    
    
}
