package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Officina.*;
import com.Team2Java12.MechAppoint.servicies.OfficinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerOfficina {

    @Autowired
    private OfficinaService officinaService;

    @Operation(summary = "Creazione di un'Officina")
    @PostMapping("/officina/create")
    public CreateOfficinaResponseDto createOfficina(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto con i campi di Officina meno l'Id")
            @RequestBody CreateOfficinaRequestDto request) {

        return officinaService.createOfficina(request);
    }
    @Operation(summary = "Richiesta per i dettagli di un'Officina con Entities correlate", description = "Basta che sia presente uno dei due campi")
    @GetMapping("/officina/get")// Ok funziona
    public GetClienteOfficinaResponseDto getOfficina(
            @Parameter(description = "ID dell'officina", required = true)
            @RequestParam Integer idOfficina,
            @Parameter(description = "Nome dell'officina", required = false)
            @RequestParam String nomeOfficina) {

        return officinaService.getOfficina(idOfficina, nomeOfficina);
    }

    @Operation(summary = "Aggiornamento di un'Officina")
    @PutMapping("/officina/put")
    public BaseResponse updateOfficina(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto per aggiornare tutti i campi di un'Officina meno l'Id")
            @RequestBody UpdateOfficinaRequestDto update) {

        officinaService.updateOfficina(update);
        return new BaseResponse();
    }

    @Operation(summary = "Aggiornamento dei clienti di un'Officina")
    @PutMapping("/officina/putclienti")
    public BaseResponse updateOfficinaClienti(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto con gli Id dei Clienti da aggiungere ad Officina")
            @RequestBody UpdateOfficinaRequestClienteDto update) {

        officinaService.updateOfficinaClienti(update);
        return new BaseResponse();
    }

    @Operation(summary = "Eliminazione di un'Officina", description = "Eliminazione logica e/o fisica di un Officina")
    @DeleteMapping("/officina/delete")
    public BaseResponse deleteOfficina(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto con l'Id dell'Officina da eliminare")
            @RequestBody DeleteOfficinaRequestDto delete) {

        return officinaService.deleteOfficina(delete);
    }

    }

