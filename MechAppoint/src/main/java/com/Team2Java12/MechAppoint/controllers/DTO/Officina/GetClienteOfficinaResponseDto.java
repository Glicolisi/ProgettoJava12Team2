package com.Team2Java12.MechAppoint.controllers.DTO.Officina;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.CreateClienteRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.Magazzino.GetMagazzinoOfficinaRequestDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.PrenotazioneOfficinaDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.CreateVeicoloRequestDTO;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Magazzino;

import java.util.ArrayList;
import java.util.List;

public class GetClienteOfficinaResponseDto extends BaseResponse {

    private Integer officinaid;
    private String nome;
    private String indirizzo;
    private String email;
    private List<CreateClienteRequestDTO> createClienteRequestDTOList;
    private List<PrenotazioneOfficinaDto> createPrenotazioneRequestDtoList;
    private List<CreateVeicoloRequestDTO> createVeicoloRequestDTOList;
    private GetMagazzinoOfficinaRequestDto getMagazzinoOfficinaRequestDto;

    public GetClienteOfficinaResponseDto(Integer officinaid, String nome, String indirizzo, String email) {
        this.officinaid = officinaid;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.createClienteRequestDTOList=new ArrayList<>();
        this.createPrenotazioneRequestDtoList=new ArrayList<>();
        this.getMagazzinoOfficinaRequestDto=new GetMagazzinoOfficinaRequestDto();

    }

    public GetClienteOfficinaResponseDto() {
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

    public GetMagazzinoOfficinaRequestDto getGetMagazzinoOfficinaRequestDto() {
        return getMagazzinoOfficinaRequestDto;
    }

    public void setGetMagazzinoOfficinaRequestDto(GetMagazzinoOfficinaRequestDto getMagazzinoOfficinaRequestDto) {
        this.getMagazzinoOfficinaRequestDto = getMagazzinoOfficinaRequestDto;
    }
}
