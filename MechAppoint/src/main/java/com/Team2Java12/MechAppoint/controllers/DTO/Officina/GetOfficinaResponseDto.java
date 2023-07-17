package com.Team2Java12.MechAppoint.controllers.DTO.Officina;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;

import java.util.List;

public class GetOfficinaResponseDto extends BaseResponse {

    private Integer officinaid;
    private String nome;
    private String indirizzo;
    private String email;
    private List<Cliente>clienteList;
    private ValidationEnum validation;

    public GetOfficinaResponseDto(Integer officinaid, String nome, String indirizzo, String email, ValidationEnum validation) {
        this.officinaid = officinaid;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.validation = validation;
    }

    public GetOfficinaResponseDto() {
    }

    public Integer getOfficinaid() {
        return officinaid;
    }

    public void setOfficinaid(Integer officinaid) {
        this.officinaid = officinaid;
    }

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

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }
}
