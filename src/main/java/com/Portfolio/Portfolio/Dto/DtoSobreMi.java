package com.Portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSobreMi {
    @NotBlank
    private String sobreMi;
    @NotBlank
    private String sobreMiT;
    
    //contructor

    public DtoSobreMi() {
    }

    public DtoSobreMi(String sobreMi, String sobreMiT) {
        this.sobreMi = sobreMi;
        this.sobreMiT = sobreMiT;
    }
    
    //getter setter

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public String getSobreMiT() {
        return sobreMiT;
    }

    public void setSobreMiT(String sobreMiT) {
        this.sobreMiT = sobreMiT;
    }
    
    
}
