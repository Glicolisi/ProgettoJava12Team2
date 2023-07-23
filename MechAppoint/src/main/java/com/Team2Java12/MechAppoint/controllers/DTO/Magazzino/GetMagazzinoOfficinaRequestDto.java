package com.Team2Java12.MechAppoint.controllers.DTO.Magazzino;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class GetMagazzinoOfficinaRequestDto {
    private String nomeMagazzino;
    private Integer inventario;

    public String getNomeMagazzino() {
        return nomeMagazzino;
    }

    public void setNomeMagazzino(String nomeMagazzino) {
        this.nomeMagazzino = nomeMagazzino;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }
}
