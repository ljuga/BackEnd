package com.Portfolio.Portfolio.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class SobreMi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sobreMi;
    @Column(columnDefinition="VARCHAR(512)")
    private String sobreMiT;

    //constructores
    public SobreMi() {
    }

    public SobreMi(String sobreMi, String sobreMiT) {
        this.sobreMi = sobreMi;
        this.sobreMiT = sobreMiT;
    }

    //Getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
