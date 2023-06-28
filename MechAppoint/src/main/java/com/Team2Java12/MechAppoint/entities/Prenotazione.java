package com.Team2Java12.MechAppoint.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name= "Prenotazione")
public class Prenotazione {
    @Id
    @Column(name="prenotazione_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeCliente;
    private String data;
    private String orario;


    public Prenotazione() {
    }
    @OneToOne
    @JoinColumn(name = "officinaid")
    private Officina officina;


    public Prenotazione(String nomeCliente, String data, String orario) {
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.orario = orario;
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