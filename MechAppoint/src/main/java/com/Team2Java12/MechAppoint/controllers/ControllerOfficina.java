package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Officina.*;
import com.Team2Java12.MechAppoint.servicies.OfficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerOfficina {

    @Autowired
    private OfficinaService officinaService;


    @PostMapping("/officina/create")//ok funziona
    public CreateOfficinaResponseDto createOfficina(@RequestBody CreateOfficinaRequestDto request) {

        return officinaService.createOfficina(request);
    }

    @GetMapping("/officina/get")//ok funziona
    public GetOfficinaResponseDto getOfficina(@RequestParam Integer idOfficina , @RequestParam String nomeOfficina){

        return officinaService.getOfficina(idOfficina,nomeOfficina);
    }

    @PutMapping("/officina/put")// ok funziona
    public BaseResponse updateOfficina(@RequestBody UpdateOfficinaRequestDto update) {

        officinaService.updateOfficina(update);
        return new BaseResponse();
    }

    @PutMapping("/officina/putclienti")// ok funziona
    public BaseResponse updateOfficinaClienti(@RequestBody UpdateOfficinaRequestClienteDto update){
        officinaService.updateOfficinaClienti(update);
        return new BaseResponse();
    }


    @DeleteMapping("/officina/delete")// ok funziona
    public BaseResponse deleteOfficina(@RequestBody DeleteOfficinaRequestDto delete){

        return officinaService.deleteOfficina(delete);
    }


    }

