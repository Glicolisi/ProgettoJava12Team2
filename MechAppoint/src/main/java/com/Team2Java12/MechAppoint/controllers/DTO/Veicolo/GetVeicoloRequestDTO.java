package com.Team2Java12.MechAppoint.controllers.DTO.Veicolo;

public class GetVeicoloRequestDTO {
    private String targa;
    private Integer id;

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
