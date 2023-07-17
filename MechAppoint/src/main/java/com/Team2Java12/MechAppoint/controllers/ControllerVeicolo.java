package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.*;
import com.Team2Java12.MechAppoint.servicies.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerVeicolo {

    @Autowired
    private VeicoloService veicoloService;

    @PostMapping ("/veicolo/create")
    public CreateVeicoloResponseDTO createVeicolo (@RequestBody CreateVeicoloRequestDTO createVeicoloRequest) {

        return veicoloService.createVeicolo(createVeicoloRequest);
    }

    @GetMapping ("/veicolo/get")
    public GetVeicoloResponseDTO retriveVeicolo (@RequestParam Integer veicoloId, @RequestParam String veicoloTarga){
        return veicoloService.getVeicolo(veicoloId, veicoloTarga);
    }


    @PutMapping("/veicolo/put")
    public BaseResponse updateVeicolo(@RequestBody UpdateVeicoloRequestDTO updateVeicoloRequest){
        return veicoloService.updateVeicolo(updateVeicoloRequest);
    }

    @DeleteMapping("/veicolo/delete")
    public BaseResponse deleteVeicolo(@RequestBody DeleteVeicoloRequestDTO deleteVeicoloRequest) {
        return veicoloService.deleteVeicolo(deleteVeicoloRequest);
    }
}
