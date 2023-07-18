package com.Team2Java12.MechAppoint.entities;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import jakarta.persistence.*;


@Entity
@Table(name="Magazzino")
public class Magazzino {
    @Id
    @Column(name="magazzinoid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer magazzinoid;
    private String nome;
    private Integer inventario;
    private ValidationEnum status;

    @OneToOne
    @JoinColumn(name="officinaid")

    private Officina officina;

    public Magazzino(String nome, Integer inventario) {
        this.nome = nome;
        this.inventario = inventario;
    }


    public Magazzino() {
    }

    public Integer getId() {
        return magazzinoid;
    }

    public void setId(Integer id) {
        this.magazzinoid = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public ValidationEnum getStatus() {
        return status;
    }

    public void setStatus(ValidationEnum status) {
        this.status = status;
    }

    public Integer getMagazzinoid() {
        return magazzinoid;
    }

    public void setMagazzinoid(Integer magazzinoid) {
        this.magazzinoid = magazzinoid;
    }

    public Officina getOfficina() {
        return officina;
    }

    public void setOfficina(Officina officina) {
        this.officina = officina;
    }
}