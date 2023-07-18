package com.Team2Java12.MechAppoint.controllers.DTO.Cliente;

import com.Team2Java12.MechAppoint.controllers.DTO.Officina.GetClienteOfficinaResponseDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.GetPrenotazioneResponseDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.GetVeicoloResponseDTO;


import java.util.List;

public class GetClienteCompletoResponseDTO {
    private GetClienteResponseDTO cliente;
    private List<GetVeicoloResponseDTO> veicoli;
    private List<GetPrenotazioneResponseDto> prenotazioni;
    private List<GetClienteOfficinaResponseDto> officine;


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

    public List<GetClienteOfficinaResponseDto> getOfficine() {
        return officine;
    }

    public void setOfficine(List<GetClienteOfficinaResponseDto> officine) {
        this.officine = officine;
    }
}
