package com.Team2Java12.MechAppoint.controllers.DTO;

public class GetMagazzinoDTO {
    private String nomeOfficina;
    private Integer inventario;


    public String getNomeOfficina() {
        return nomeOfficina;
    }

    public void setNomeOfficina(String nomeOfficina) {
        this.nomeOfficina = nomeOfficina;
    }

    public Integer getInventario(Integer inventario) {
        return this.inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

}
