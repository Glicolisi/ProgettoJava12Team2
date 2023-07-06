package com.Team2Java12.MechAppoint.controllers.DTO;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class CreateMagazzinoRequestDTO {
    private String nomeOfficina;
    private Integer inventario;


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


}
