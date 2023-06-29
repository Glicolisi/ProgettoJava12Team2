package com.Team2Java12.MechAppoint.controllers;


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
    public ResponseEntity<Magazzino> createMagazzino (@RequestBody Magazzino magazzino){

        magazzinoService.createMagazzino(magazzino);
        return ResponseEntity.ok().build();

    }
    @GetMapping("{magazzino_id}")
    public ResponseEntity<Magazzino> retrieveMagazzino(@PathVariable("magazzino_id") Integer magazzinoid){

        return ResponseEntity.ok(magazzinoService.getMagazzino(magazzinoid));

    }

    @PutMapping("{magazzino_id}")

    public ResponseEntity<Magazzino>updateMagazzino(@RequestBody Magazzino magazzino, @PathVariable("magazzino_id") Integer magazzinoid){

        magazzinoService.updateMagazzino(magazzino,magazzinoid);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("{magazzino_id}")

    public ResponseEntity<Magazzino> deleteMagazzino (@PathVariable ("magazzino_id") Integer magazzinoid){
        magazzinoService.deleteMagazzino(magazzinoid);
        return ResponseEntity.ok().build();
    }
}
