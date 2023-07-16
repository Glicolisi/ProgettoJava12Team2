package com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione;


import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class CreatePrenotazioneRequestDto {
    private String nomeCliente;
    private String data;
    private String orario;
    private ValidationEnum validation = ValidationEnum.ACTIVE;
    private Integer officinaid;
    private Integer clienteId;

    public Integer getOfficinaid() {
        return officinaid;
    }

    public void setOfficinaid(Integer officinaid) {
        this.officinaid = officinaid;
    }

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

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
