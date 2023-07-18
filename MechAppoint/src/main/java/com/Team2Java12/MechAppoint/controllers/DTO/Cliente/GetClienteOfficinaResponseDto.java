package com.Team2Java12.MechAppoint.controllers.DTO.Cliente;

import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.PrenotazioneOfficinaDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.CreateVeicoloRequestDTO;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Magazzino;

import java.util.ArrayList;
import java.util.List;

public class GetClienteOfficinaResponseDto {
    private Integer officinaid;
    private String nome;
    private String indirizzo;
    private String email;
    private Magazzino magazzino;
    private ValidationEnum validation;

    public GetClienteOfficinaResponseDto(Integer officinaid, String nome, String indirizzo, String email, ValidationEnum validation) {
        this.officinaid = officinaid;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.validation = validation;


    }

    public GetClienteOfficinaResponseDto() {
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

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }
}

