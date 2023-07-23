package com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class GetPrenotazioneResponseDto extends BaseResponse {

    private Integer id;
    private String nomeCliente;
    private String data;
    private String orario;

    public GetPrenotazioneResponseDto(Integer id, String nomeCliente, String data, String orario) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.orario = orario;
    }
    public GetPrenotazioneResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

}