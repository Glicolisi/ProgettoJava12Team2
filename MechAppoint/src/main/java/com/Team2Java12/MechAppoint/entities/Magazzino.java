package com.Team2Java12.MechAppoint.entities;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="Magazzino")
public class Magazzino {
    @Id
    @Column(name="magazzino_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeOfficina;
    private int inventario;


    public Magazzino() {
    }
    @OneToOne
    @JoinColumn(name="officinaid")
    private Officina officina;

    public Magazzino(String nomeOfficina, int inventario) {
        this.nomeOfficina = nomeOfficina;
        this.inventario = inventario;
    }

    public Magazzino(Integer id, String nomeOfficina, int inventario, Officina officina) {
        this.id = id;
        this.nomeOfficina = nomeOfficina;
        this.inventario = inventario;
        this.officina = officina;
    }

    public Magazzino(String nomeOfficina, int inventario, Officina officina) {
        this.nomeOfficina = nomeOfficina;
        this.inventario = inventario;
        this.officina = officina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeOfficina() {
        return nomeOfficina;
    }

    public void setNomeOfficina(String nomeOfficina) {
        this.nomeOfficina = nomeOfficina;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
}