package com.Team2Java12.MechAppoint.controllers.DTO.Officina;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.CreateClienteRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.CreateClienteResponseDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.CreatePrenotazioneRequestDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.PrenotazioneOfficinaDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.CreateVeicoloRequestDTO;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.entities.Magazzino;

import java.util.ArrayList;
import java.util.List;

public class GetOfficinaResponseDto extends BaseResponse {

    private Integer officinaid;
    private String nome;
    private String indirizzo;
    private String email;
    private List<CreateClienteRequestDTO> createClienteRequestDTOList;
    private List<PrenotazioneOfficinaDto> createPrenotazioneRequestDtoList;
    private List<CreateVeicoloRequestDTO> createVeicoloRequestDTOList;
    private Magazzino magazzino;
    private ValidationEnum validation;

    public GetOfficinaResponseDto(Integer officinaid, String nome, String indirizzo, String email, ValidationEnum validation) {
        this.officinaid = officinaid;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.validation = validation;
        this.createClienteRequestDTOList=new ArrayList<>();
        this.createPrenotazioneRequestDtoList=new ArrayList<>();
        this.magazzino=new Magazzino();

    }

    public GetOfficinaResponseDto() {
    }

    public Integer getOfficinaid() {
        return officinaid;
    }

    public void setOfficinaid(Integer officinaid) {
        this.officinaid = officinaid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CreateClienteRequestDTO> getCreateClienteRequestDTOList() {
        return createClienteRequestDTOList;
    }

    public void setCreateClienteRequestDTOList(List<CreateClienteRequestDTO> createClienteRequestDTOList) {
        this.createClienteRequestDTOList = createClienteRequestDTOList;
    }

    public List<PrenotazioneOfficinaDto> getCreatePrenotazioneRequestDtoList() {
        return createPrenotazioneRequestDtoList;
    }

    public void setCreatePrenotazioneRequestDtoList(List<PrenotazioneOfficinaDto> createPrenotazioneRequestDtoList) {
        this.createPrenotazioneRequestDtoList = createPrenotazioneRequestDtoList;
    }

    public List<CreateVeicoloRequestDTO> getCreateVeicoloRequestDTOList() {
        return createVeicoloRequestDTOList;
    }

    public void setCreateVeicoloRequestDTOList(List<CreateVeicoloRequestDTO> createVeicoloRequestDTOList) {
        this.createVeicoloRequestDTOList = createVeicoloRequestDTOList;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }
}
