package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.*;
import com.Team2Java12.MechAppoint.servicies.VeicoloService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerVeicolo {

    @Autowired
    private VeicoloService veicoloService;
    @Operation(summary = "Creazione di un Veicolo associato ad un cliente")
    @PostMapping ("/veicolo/create")
    public CreateVeicoloResponseDTO createVeicolo (@RequestBody CreateVeicoloRequestDTO createVeicoloRequest) {

        return veicoloService.createVeicolo(createVeicoloRequest);
    }
    @Operation(summary = "Richiesta per i dettagli di un veicolo", description = "Basta che sia presente uno dei due campi")
    @GetMapping ("/veicolo/get")
    public GetVeicoloResponseDTO retriveVeicolo (@RequestParam Integer veicoloId, @RequestParam String veicoloTarga){
        return veicoloService.getVeicolo(veicoloId, veicoloTarga);
    }

    @Operation(summary = "Aggiornamento dei dettagli di un veicolo")
    @PutMapping("/veicolo/put")
    public BaseResponse updateVeicolo(@RequestBody UpdateVeicoloRequestDTO updateVeicoloRequest){
        return veicoloService.updateVeicolo(updateVeicoloRequest);
    }
    @Operation(summary = "Eliminazione logica di un veicolo")
    @DeleteMapping("/veicolo/delete")
    public BaseResponse deleteVeicolo(@RequestBody DeleteVeicoloRequestDTO deleteVeicoloRequest) {
        return veicoloService.deleteVeicolo(deleteVeicoloRequest);
    }
}
