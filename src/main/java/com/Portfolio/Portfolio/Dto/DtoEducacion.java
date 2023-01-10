package com.Portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private String nombreED;
    @NotBlank
    private String nombreED2;
    @NotBlank
    private String descripcionED;

    private String imgED;

    //constructor
    public DtoEducacion() {
    }

    public DtoEducacion(String nombreED, String nombreED2, String descripcionED, String imgED) {
        this.nombreED = nombreED;
        this.nombreED2 = nombreED2;
        this.descripcionED = descripcionED;
        this.imgED = imgED;
    }

    //getter setter
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
