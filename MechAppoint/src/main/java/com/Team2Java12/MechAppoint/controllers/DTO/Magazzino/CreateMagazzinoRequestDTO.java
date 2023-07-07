package com.Team2Java12.MechAppoint.controllers.DTO.Magazzino;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class CreateMagazzinoRequestDTO {
    private String nomeMagazzino;
    private Integer inventario;
    private ValidationEnum validation = ValidationEnum.ACTIVE;


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

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }
}
