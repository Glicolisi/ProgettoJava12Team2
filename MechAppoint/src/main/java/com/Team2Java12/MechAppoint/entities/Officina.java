package com.Team2Java12.MechAppoint.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="Officina")
public class Officina {

@Id
@Column(name="officinaid")
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Integer officinaid;
private String nome;
private String indirizzo;
private String email;
private ValidationEnum validation;

    public Officina(Integer officinaid, String nome, String indirizzo, String email, ValidationEnum validation) {
        this.officinaid = officinaid;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.validation = validation;
    }

    public Officina(String nome, String indirizzo, String email, ValidationEnum validation) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.validation = validation;
    }

    public Officina() {
    }

    @ManyToMany(mappedBy = "officine")
    private List<Cliente> clienti;

    @OneToOne(mappedBy ="officina")
    private Magazzino magazzino;

    @OneToMany(mappedBy = "officina")
    private List<Prenotazione> prenotazioni;

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public Integer getOfficinaid() {
        return officinaid;
    }

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
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

    public List<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }
}
