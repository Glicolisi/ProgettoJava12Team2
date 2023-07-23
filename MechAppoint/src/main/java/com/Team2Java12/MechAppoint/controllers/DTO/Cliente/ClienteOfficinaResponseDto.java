package com.Team2Java12.MechAppoint.controllers.DTO.Cliente;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Magazzino;

public class ClienteOfficinaResponseDto {
    private Integer officinaid;
    private String nome;
    private String indirizzo;
    private String email;

    public ClienteOfficinaResponseDto(Integer officinaid, String nome, String indirizzo, String email) {
        this.officinaid = officinaid;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;



    }

    public ClienteOfficinaResponseDto() {
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

}

