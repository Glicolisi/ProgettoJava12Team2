package com.Team2Java12.MechAppoint.controllers.DTO.Magazzino;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class GetMagazzinoResponseDTO extends BaseResponse {
    private String nome;

    public GetMagazzinoResponseDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
