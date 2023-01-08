package com.Portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String nombrePT;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String nombreL;

    private String imgP;

    //contructor
    public DtoProyectos() {
    }

    public DtoProyectos(String nombreP, String nombrePT, String descripcionP, String nombreL, String imgP) {
        this.nombreP = nombreP;
        this.nombrePT = nombrePT;
        this.descripcionP = descripcionP;
        this.nombreL = nombreL;
        this.imgP = imgP;
    }
    //getter setter

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

    public String getImgP() {
        return imgP;
    }

    public void setImgL(String imgP) {
        this.imgP = imgP;
    }

}
