package com.Team2Java12.MechAppoint.controllers.DTO.Cliente;

import com.Team2Java12.MechAppoint.controllers.DTO.Officina.UpdateOfficinaRequestDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.CreatePrenotazioneRequestDto;

public class SetClienteRequestDto {

    private Integer cliente_id;
    private Integer officina_id;
    private CreatePrenotazioneRequestDto createPrenotazioneRequestDto;

    public Integer getOfficina_id() {
        return officina_id;
    }

    public void setOfficina_id(Integer officina_id) {
        this.officina_id = officina_id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public CreatePrenotazioneRequestDto getCreatePrenotazioneRequestDto() {
        return createPrenotazioneRequestDto;
    }

    public void setCreatePrenotazioneRequestDto(CreatePrenotazioneRequestDto createPrenotazioneRequestDto) {
        this.createPrenotazioneRequestDto = createPrenotazioneRequestDto;
    }

}
