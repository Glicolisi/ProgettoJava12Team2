package com.Team2Java12.MechAppoint.controllers;


import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.entities.Magazzino;

import com.Team2Java12.MechAppoint.servicies.MagazzinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerMagazzino {

    @Autowired

    private MagazzinoService magazzinoService;


    @PostMapping("/postMagazzino")
    public ResponseEntity<?> createMagazzino(@RequestBody CreateMagazzinoRequestDTO magazzinoDTO) {

        magazzinoService.createMagazzino(magazzinoDTO);
        return ResponseEntity.ok().build();

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

    public BaseResponse deleteMagazzino(@RequestBody DeletaMagazzinoRequestDTO deletaMagazzinoRequestDTO) {
        return magazzinoService.deleteMagazzino(deletaMagazzinoRequestDTO);
    }
}
