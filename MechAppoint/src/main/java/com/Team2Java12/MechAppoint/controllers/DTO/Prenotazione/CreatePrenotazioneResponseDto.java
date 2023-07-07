package com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;

public class CreatePrenotazioneResponseDto extends BaseResponse {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}