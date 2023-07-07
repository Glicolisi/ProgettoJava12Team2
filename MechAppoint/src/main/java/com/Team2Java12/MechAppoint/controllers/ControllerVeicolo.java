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

    @PostMapping ("/createVeicolo")
    public CreateVeicoloResponseDTO createVeicolo (@RequestBody CreateVeicoloRequestDTO createVeicoloRequest) {

        return veicoloService.createVeicolo(createVeicoloRequest);
    }

    @GetMapping ("/retriveVeicolo")
    public GetVeicoloResponseDTO retriveVeicolo (@RequestBody GetVeicoloRequestDTO getVeicoloRequest){
        return veicoloService.getVeicolo(getVeicoloRequest);
    }


    @PutMapping("/updateVeicolo")
    public BaseResponse updateVeicolo(@RequestBody UpdateVeicoloRequestDTO updateVeicoloRequest){
        return veicoloService.updateVeicolo(updateVeicoloRequest);
    }

    @DeleteMapping("/deleteVeicolo")
    public BaseResponse deleteVeicolo(@RequestBody DeleteVeicoloRequestDTO deleteVeicoloRequest) {
        return veicoloService.deleteVeicolo(deleteVeicoloRequest);
    }
}
