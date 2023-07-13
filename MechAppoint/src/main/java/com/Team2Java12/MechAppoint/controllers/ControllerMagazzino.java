package com.Team2Java12.MechAppoint.controllers;


import com.Team2Java12.MechAppoint.controllers.DTO.*;

import com.Team2Java12.MechAppoint.controllers.DTO.Magazzino.CreateMagazzinoRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.Magazzino.DeleteMagazzinoRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.Magazzino.GetMagazzinoDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.Magazzino.UpdateMagazzinoRequestDTO;
import com.Team2Java12.MechAppoint.servicies.MagazzinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerMagazzino {
//TODO: Fare restcontroller con dto sia in entrata e risposta
    @Autowired

    private MagazzinoService magazzinoService;


    @PostMapping("/postMagazzino")
    public BaseResponse createMagazzino(@RequestBody CreateMagazzinoRequestDTO magazzinoDTO) {

        return magazzinoService.createMagazzino(magazzinoDTO);


    }

    @GetMapping("{magazzino_id}")
    public GetMagazzinoDTO retriveMagazzino(@PathVariable("magazzino_id") Integer magazzinoId) {
        return magazzinoService.getMagazzino(magazzinoId);
    }

    @PutMapping("/updateMagazzino")

    public BaseResponse updateMagazzino(@RequestBody UpdateMagazzinoRequestDTO magazzinoRequestDTO) {
        return magazzinoService.updateMagazzino(magazzinoRequestDTO);

    }

    @DeleteMapping("/deleteMagazzino")

    public BaseResponse deleteMagazzino(@RequestBody DeleteMagazzinoRequestDTO deleteMagazzinoRequestDTO) {
        return magazzinoService.deleteMagazzino(deleteMagazzinoRequestDTO);
    }
}
