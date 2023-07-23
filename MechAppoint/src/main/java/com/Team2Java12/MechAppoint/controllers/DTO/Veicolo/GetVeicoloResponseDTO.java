package com.Team2Java12.MechAppoint.controllers.DTO.Veicolo;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class GetVeicoloResponseDTO {

    private String tipoVeicolo;
    private String targa;
    private String dataImmatricolazione;

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

}
