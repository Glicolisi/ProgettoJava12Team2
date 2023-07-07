package com.Team2Java12.MechAppoint.controllers.DTO.Officina;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class CreateOfficinaRequestDto {

    private String nome;
    private String indirizzo;
    private String email;
    private ValidationEnum validation = ValidationEnum.ACTIVE;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }
}
