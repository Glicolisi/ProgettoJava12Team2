package com.Team2Java12.MechAppoint.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Prenotazione")
public class Prenotazione {
    @Id
    @Column(name="prenotazioneid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeCliente;
    //TODO cambiare in Timestamp data e orario
    private String data;
    private String orario;

    public Prenotazione(String nomeCliente, String data, String orario) {
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.orario = orario;
    }

    public Prenotazione() {
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
}
