package com.Team2Java12.MechAppoint.entities;

import jakarta.persistence.*;


@Entity
@Table(name="Magazzino")
public class Magazzino {
    @Id
    @Column(name="magazzinoid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer magazzinoid;
    private String nomeOfficina;
    private Integer inventario;

    @OneToOne
    @JoinColumn(name="officinaid")
    private Officina officina;

    public Magazzino(String nomeOfficina, Integer inventario) {
        this.nomeOfficina = nomeOfficina;
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

    public String getNomeOfficina() {
        return nomeOfficina;
    }

    public void setNomeOfficina(String nomeOfficina) {
        this.nomeOfficina = nomeOfficina;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }
}