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
    private String nomeMagazzino;
    private Integer inventario;
    private ValidationEnum status;

    @OneToOne
    @JoinColumn(name="officinaid")

    private Officina officina;

    public Magazzino(String nomeOfficina, Integer inventario) {
        this.nomeMagazzino = nomeOfficina;
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
        return nomeMagazzino;
    }

    public void setNomeOfficina(String nomeOfficina) {
        this.nomeMagazzino = nomeOfficina;
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
}