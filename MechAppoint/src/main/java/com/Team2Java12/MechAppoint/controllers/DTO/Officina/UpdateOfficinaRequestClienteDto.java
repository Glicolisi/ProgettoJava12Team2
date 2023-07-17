package com.Team2Java12.MechAppoint.controllers.DTO.Officina;

import java.util.List;

public class UpdateOfficinaRequestClienteDto extends UpdateOfficinaRequestDto {

    private Integer officina_id;
    private List<Integer> cliente_id;


    public Integer getOfficina_id() {
        return officina_id;
    }

    public void setOfficina_id(Integer officina_id) {
        this.officina_id = officina_id;
    }

    public List<Integer> getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(List<Integer> cliente_id) {
        this.cliente_id = cliente_id;
    }
}
