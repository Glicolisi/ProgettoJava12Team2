package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.*;
import com.Team2Java12.MechAppoint.servicies.PrenotazioneService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerPrenotazione {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Operation(summary = "Creazione di una prenotazione", description = "Prenotazione correlata ad un'Officina e relativo Cliente")
    @PostMapping("/prenotazione/create")
    public CreatePrenotazioneResponseDto createPrenotazione(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto con i dettagli della Prenotazione e gli Id del Cliente e dell'Officina correlati")
            @RequestBody CreatePrenotazioneRequestDto request) {

        return prenotazioneService.createPrenotazione(request);
    }

    @GetMapping("/prenotazione/get")
    public GetPrenotazioneResponseDto getPrenotazione(@RequestParam Integer prenotazioneId){
        return prenotazioneService.getPrenotazioneResponseDto(prenotazioneId);

    }

    @PutMapping("/prenotazione/put")

    public BaseResponse updateOfficina(@RequestBody UpdatePrenotazioneRequestDto updatePrenotazioneRequestDto) {

        prenotazioneService.updatePrenotazione(updatePrenotazioneRequestDto);
        return new BaseResponse();

    }
    @DeleteMapping("/prenotazione/delete")
    public BaseResponse deletePrenotazione(@RequestBody DeletePrenotazioneRequestDto deletePrenotazioneRequestDto){

        return prenotazioneService.deletePrenotazione(deletePrenotazioneRequestDto);

    }
}
