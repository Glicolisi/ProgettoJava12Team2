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
//private List<Impiegato> impiegatoList;
//private List<Listino> listinoList;

    public Officina( String nome, String indirizzo, String email) {

        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
//        this.impiegatoList = new ArrayList<>();
//        this.listinoList = new ArrayList<>();

    }

    public Officina() {
    }

    @ManyToMany(mappedBy = "officine")
    private List<Cliente> clienti;




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

//    public List<Impiegato> getImpiegatoList() {
//        return impiegatoList;
//    }
//
//    public void setImpiegatoList(List<Impiegato> impiegatoList) {
//        this.impiegatoList = impiegatoList;
//    }

//    public List<Listino> getListinoList() {
//        return listinoList;
//    }
//
//    public void setListinoList(List<Listino> listinoList) {
//        this.listinoList = listinoList;
//    }

    public List<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }
}
