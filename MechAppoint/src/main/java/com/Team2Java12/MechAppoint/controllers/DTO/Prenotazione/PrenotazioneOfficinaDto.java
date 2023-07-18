package com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class PrenotazioneOfficinaDto {

    private String nomeCliente;
    private String data;
    private String orario;
    private ValidationEnum validation = ValidationEnum.ACTIVE;


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }


}



