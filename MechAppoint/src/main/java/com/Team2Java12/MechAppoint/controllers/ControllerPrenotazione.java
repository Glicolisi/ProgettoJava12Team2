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
    @PostMapping("/prenotazione/create") //FUNZIONA
    public CreatePrenotazioneResponseDto createPrenotazione(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto con i dettagli della Prenotazione e gli Id del Cliente e dell'Officina correlati")
            @RequestBody CreatePrenotazioneRequestDto request) {

        return prenotazioneService.createPrenotazione(request);
    }
    @Operation(summary = "Richiesta dei dettagli di una prenotazione")
    @GetMapping("/prenotazione/get") //FUNZIONA
    public GetPrenotazioneResponseDto getPrenotazione(@RequestParam Integer prenotazioneId){
        return prenotazioneService.getPrenotazioneResponseDto(prenotazioneId);

    }
    @Operation(summary = "Aggiornamento dei dettagli di una prenotazione")
    @PutMapping("/prenotazione/put")//FUNZIONA

    public BaseResponse updateOfficina(@RequestBody UpdatePrenotazioneRequestDto updatePrenotazioneRequestDto) {

        prenotazioneService.updatePrenotazione(updatePrenotazioneRequestDto);
        return new BaseResponse();

    }
    @Operation(summary = "Cancellazione logica di una prenotazione")
    @DeleteMapping("/prenotazione/delete")//FUNZIONA
    public BaseResponse deletePrenotazione(@RequestBody DeletePrenotazioneRequestDto deletePrenotazioneRequestDto){

        return prenotazioneService.deletePrenotazione(deletePrenotazioneRequestDto);

    }
}
