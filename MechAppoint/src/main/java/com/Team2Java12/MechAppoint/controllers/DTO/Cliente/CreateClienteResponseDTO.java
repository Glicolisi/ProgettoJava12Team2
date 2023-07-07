package com.Team2Java12.MechAppoint.controllers.DTO.Cliente;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;

public class CreateClienteResponseDTO extends BaseResponse {
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
