package com.Team2Java12.MechAppoint.controllers;


import com.Team2Java12.MechAppoint.controllers.DTO.*;

import com.Team2Java12.MechAppoint.controllers.DTO.Magazzino.*;
import com.Team2Java12.MechAppoint.servicies.MagazzinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerMagazzino {
    @Autowired
    private MagazzinoService magazzinoService;


    @PostMapping("/magazzino/create")
    public BaseResponse createMagazzino(@RequestBody CreateMagazzinoRequestDTO magazzinoDTO) {
        return magazzinoService.createMagazzino(magazzinoDTO);
    }

    @GetMapping("/magazzino/get")
    public GetMagazzinoResponseDTO getMagazzino(@RequestParam Integer magazzinoId) {
        return magazzinoService.getMagazzino(magazzinoId);
    }

    @PutMapping("/magazzino/put")
    public BaseResponse updateMagazzino(@RequestBody UpdateMagazzinoRequestDTO magazzinoRequestDTO) {
        magazzinoService.updateMagazzino(magazzinoRequestDTO);
        return new BaseResponse();
    }

    @DeleteMapping("/magazzino/delete")
    public BaseResponse deleteMagazzino(@RequestBody DeleteMagazzinoRequestDTO deleteMagazzinoRequestDTO) {
        return magazzinoService.deleteMagazzino(deleteMagazzinoRequestDTO);
    }
}
