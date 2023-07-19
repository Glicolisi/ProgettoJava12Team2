package com.Team2Java12.MechAppoint.controllers;


import com.Team2Java12.MechAppoint.controllers.DTO.*;

import com.Team2Java12.MechAppoint.controllers.DTO.Magazzino.*;
import com.Team2Java12.MechAppoint.servicies.MagazzinoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerMagazzino {
    @Autowired
    private MagazzinoService magazzinoService;

    @Operation(summary = "Creazione di un magazzino associato ad un'officina")
    @PostMapping("/magazzino/create")
    public BaseResponse createMagazzino(@RequestBody CreateMagazzinoRequestDTO magazzinoDTO) {
        return magazzinoService.createMagazzino(magazzinoDTO);
    }
    @Operation(summary = "Richiesta per i dettagli di un magazzino")
    @GetMapping("/magazzino/get")
    public GetMagazzinoResponseDTO getMagazzino(@RequestParam Integer magazzinoId) {
        return magazzinoService.getMagazzino(magazzinoId);
    }
    @Operation(summary = "Aggiornamento dei dettagli di un magazzino")
    @PutMapping("/magazzino/put")
    public BaseResponse updateMagazzino(@RequestBody UpdateMagazzinoRequestDTO magazzinoRequestDTO) {
        magazzinoService.updateMagazzino(magazzinoRequestDTO);
        return new BaseResponse();
    }
    @Operation(summary = "Cancellazione logica di un magazzino")
    @DeleteMapping("/magazzino/delete")
    public BaseResponse deleteMagazzino(@RequestBody DeleteMagazzinoRequestDTO deleteMagazzinoRequestDTO) {
        return magazzinoService.deleteMagazzino(deleteMagazzinoRequestDTO);
    }
}
