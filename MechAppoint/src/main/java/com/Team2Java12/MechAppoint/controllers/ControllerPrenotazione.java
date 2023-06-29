package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.servicies.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ControllerPrenotazione {

    @Autowired
    private PrenotazioneService prenotazioneService;


    @PostMapping("/postPrenotazione")
    public ResponseEntity<Prenotazione> createPrenotazione (@RequestBody Prenotazione prenotazione){

        prenotazioneService.createPrenotazione(prenotazione);
        return ResponseEntity.ok().build();

    }
    @GetMapping("{prenotazione_id}")
    public ResponseEntity<Prenotazione> retrievePrenotazione(@PathVariable("prenotazione_id") Integer prenotazioneid){

        return ResponseEntity.ok(prenotazioneService.getPrenotazione(prenotazioneid));

    }

    @PutMapping("{prenotazione_id}")

    public ResponseEntity<Prenotazione>updatePrenotazione(@RequestBody Prenotazione prenotazione, @PathVariable("prenotazione_id") Integer prenotazioneid){

        prenotazioneService.updatePrenotazione(prenotazione,prenotazioneid);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("{prenotazione_id}")

    public ResponseEntity<Prenotazione> deletePrenotazione (@PathVariable ("prenotazione_id") Integer prenotazioneid){
        prenotazioneService.deletePrenotazione(prenotazioneid);
        return ResponseEntity.ok().build();
    }
}
