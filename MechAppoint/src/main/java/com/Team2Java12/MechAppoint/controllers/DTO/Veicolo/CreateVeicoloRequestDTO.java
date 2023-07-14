package com.Team2Java12.MechAppoint.controllers.DTO.Veicolo;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class CreateVeicoloRequestDTO {
    private String tipoVeicolo;
    private String targa;
    private String dataImmatricolazione;
    private Integer id_cliente;

    private ValidationEnum validation = ValidationEnum.ACTIVE;

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipoVeicolo() {
        return tipoVeicolo;
    }

    public void setTipoVeicolo(String tipoVeicolo) {
        this.tipoVeicolo = tipoVeicolo;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getDataImmatricolazione() {
        return dataImmatricolazione;
    }

    public void setDataImmatricolazione(String dataImmatricolazione) {
        this.dataImmatricolazione = dataImmatricolazione;
    }
}
