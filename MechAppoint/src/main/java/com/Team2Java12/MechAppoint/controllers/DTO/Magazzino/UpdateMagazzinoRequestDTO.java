package com.Team2Java12.MechAppoint.controllers.DTO.Magazzino;

public class UpdateMagazzinoRequestDTO {
    private String nomeOfficina;
    private Integer inventario;
    private  Integer id;

    public String getNomeOfficina() {
        return nomeOfficina;
    }

    public void setNomeOfficina(String nomeOfficina) {
        this.nomeOfficina = nomeOfficina;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
