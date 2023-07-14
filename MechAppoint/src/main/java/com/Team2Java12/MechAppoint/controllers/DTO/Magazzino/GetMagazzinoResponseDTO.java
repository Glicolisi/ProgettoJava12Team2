package com.Team2Java12.MechAppoint.controllers.DTO.Magazzino;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class GetMagazzinoResponseDTO extends BaseResponse {
    private Integer magazzino_id;
    private String nome;
    private ValidationEnum validation;

    public GetMagazzinoResponseDTO(Integer magazzino_id, String nome, ValidationEnum validation) {
        this.magazzino_id = magazzino_id;
        this.nome = nome;
        this.validation = validation;
    }

    public GetMagazzinoResponseDTO() {
    }

    public Integer getMagazzino_id() {
        return magazzino_id;
    }

    public void setMagazzino_id(Integer magazzino_id) {
        this.magazzino_id = magazzino_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }
}
