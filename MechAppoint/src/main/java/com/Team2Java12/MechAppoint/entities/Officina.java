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
private List<Impiegato> impiegatoList;
private List<Listino> listinoList;

    public Officina( String nome, String indirizzo, String email) {

        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.impiegatoList = new ArrayList<>();
        this.listinoList = new ArrayList<>();

    }

    public Officina() {
    }
}
