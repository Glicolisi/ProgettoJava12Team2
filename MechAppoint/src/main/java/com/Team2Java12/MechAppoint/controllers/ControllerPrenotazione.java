package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.servicies.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerPrenotazione {

    @Autowired
    private PrenotazioneService prenotazioneService;


    @PostMapping("/prenotazione/create")
    public CreatePrenotazioneResponseDto createPrenotazione (@RequestBody CreatePrenotazioneRequestDto request){

        return prenotazioneService.createPrenotazione(request);

    }
    @GetMapping("/prenotazione/get")
    public GetPrenotazioneResponseDto getPrenotazione(@RequestBody GetPrenotazioneRequestDto getPrenotazioneRequestDto){

        return prenotazioneService.getPrenotazioneResponseDto(getPrenotazioneRequestDto);

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
