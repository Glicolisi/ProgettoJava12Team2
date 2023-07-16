package com.Team2Java12.MechAppoint.controllers.DTO.Cliente;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.GetPrenotazioneResponseDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.GetVeicoloResponseDTO;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.entities.Veicolo;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class GetClienteCompletoResponseDTO {
    GetClienteResponseDTO cliente;

    private List<GetVeicoloResponseDTO> veicoli;

    private List<GetPrenotazioneResponseDto> prenotazioni;


    public GetClienteResponseDTO getCliente() {
        return cliente;
    }

    public void setCliente(GetClienteResponseDTO cliente) {
        this.cliente = cliente;
    }

    public List<GetVeicoloResponseDTO> getVeicoli() {
        return veicoli;
    }

    public void setVeicoli(List<GetVeicoloResponseDTO> veicoli) {
        this.veicoli = veicoli;
    }

    public List<GetPrenotazioneResponseDto> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<GetPrenotazioneResponseDto> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }
}
