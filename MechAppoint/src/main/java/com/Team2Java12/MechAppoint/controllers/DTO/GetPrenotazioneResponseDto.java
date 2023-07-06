package com.Team2Java12.MechAppoint.controllers.DTO;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class GetPrenotazioneResponseDto extends BaseResponse {

    private Integer id;
    private String nomeCliente;
    private String data;
    private String orario;
    private ValidationEnum validation;

    public GetPrenotazioneResponseDto(Integer id, String nomeCliente, String data, String orario, ValidationEnum validation) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.orario = orario;
        this.validation = validation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}