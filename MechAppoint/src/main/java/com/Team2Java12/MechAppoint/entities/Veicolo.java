package com.Team2Java12.MechAppoint.entities;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import jakarta.persistence.*;

@Entity
@Table (name = "Veicoli")
public class Veicolo {

    @Id
    @Column (name = "VeicoloId")
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;
    private String tipoVeicolo;
    private String targa;
    private String dataImmatricolazione;
    private String proprietario;
    private ValidationEnum status;

    public Veicolo(Integer id, String tipoVeicolo, String targa, String dataImmatricolazione, String proprietario) {
        this.id = id;
        this.tipoVeicolo = tipoVeicolo;
        this.targa = targa;
        this.dataImmatricolazione = dataImmatricolazione;
        this.proprietario = proprietario;
    }

    public Veicolo() {
    }

    @ManyToOne
    @JoinColumn(name = "Id")
    private Cliente cliente;

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoVeicolo() {
        return tipoVeicolo;
    }

    public void setTipoVeicolo(String tipoVeicolo) {
        this.tipoVeicolo = tipoVeicolo;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getDataImmatricolazione() {
        return dataImmatricolazione;
    }

    public void setDataImmatricolazione(String dataImmatricolazione) {
        this.dataImmatricolazione = dataImmatricolazione;
    }

    public ValidationEnum getStatus() {
        return status;
    }

    public void setStatus(ValidationEnum status) {
        this.status = status;
    }
}
