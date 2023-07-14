package com.Team2Java12.MechAppoint.controllers.DTO.Magazzino;

public class GetMagazzinoRequestDTO {
    private String nomeMagazzino;
    private Integer id;


    public String getNomeMagazzino() {
        return nomeMagazzino;
    }

    public void setNomeMagazzino(String nomeMagazzino) {
        this.nomeMagazzino = nomeMagazzino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
