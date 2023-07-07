package com.Team2Java12.MechAppoint.controllers.DTO.Veicolo;

public class UpdateVeicoloRequestDTO {

    private String tipoVeicolo;
    private String targa;
    private String dataImmatricolazione;
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
