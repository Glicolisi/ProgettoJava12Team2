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


    @PostMapping("/officina/create")
    public CreateOfficinaResponseDto createOfficina(@RequestBody CreateOfficinaRequestDto request) {

        return officinaService.createOfficina(request);

    }

    @GetMapping("/officina/get")
    public GetOfficinaResponseDto getOfficina(@RequestParam Integer id_officina , @RequestParam String nome_officina){

        return officinaService.getOfficina(id_officina,nome_officina);
    }

    @PutMapping("/officina/put")
    public BaseResponse updateOfficina(@RequestBody UpdateOfficinaRequestDto update) {

        officinaService.updateOfficina(update);
        return new BaseResponse();
    }

    @PutMapping("/officina/putclienti")
    public BaseResponse updateOfficinaClienti(@RequestBody UpdateOfficinaRequestClienteDto update){
        officinaService.updateOfficinaClienti(update);
        return new BaseResponse();
    }


    @DeleteMapping("/officina/delete")
    public BaseResponse deleteOfficina(@RequestBody DeleteOfficinaRequestDto delete){

        return officinaService.deleteOfficina(delete);

    }


    }

