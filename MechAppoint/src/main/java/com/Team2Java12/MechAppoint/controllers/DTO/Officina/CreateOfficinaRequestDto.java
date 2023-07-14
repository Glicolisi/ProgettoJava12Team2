package com.Team2Java12.MechAppoint.controllers.DTO.Officina;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;

import java.util.List;

public class CreateOfficinaRequestDto {

    private String nome;
    private String indirizzo;
    private String email;
    private List<Integer> clienteIdList;
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

    public List<Integer> getClienteIdList() {
        return clienteIdList;
    }

    public void setClienteIdList(List<Integer> clienteIdList) {
        this.clienteIdList = clienteIdList;
    }

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }
}
