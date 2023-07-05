package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.CreateVeicoloRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.DeleteVeicoloRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.UpdateVeicoloRequestDTO;
import com.Team2Java12.MechAppoint.entities.Veicolo;
import com.Team2Java12.MechAppoint.servicies.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VeicoloController {

    @Autowired
    private VeicoloService veicoloService;

    @PostMapping ("/insertVeicolo")
    public ResponseEntity<?> createVeicolo (@RequestBody CreateVeicoloRequestDTO veicoloDTO) {
        veicoloService.createVeicolo(veicoloDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping ("{veicolo_id}")
    public ResponseEntity<ResponseEntity<?>> retriveVeicolo (@PathVariable("veicolo_id") Integer veicoloId){
        return ResponseEntity.ok(veicoloService.getVeicolo(veicoloId));
    }


    @PutMapping("/updateVeicolo")
    public BaseResponse updateVeicolo(@RequestBody UpdateVeicoloRequestDTO veicoloToUpdate){
        return veicoloService.updateVeicolo(veicoloToUpdate);
    }

    @DeleteMapping("/deleteVeicolo")
    public BaseResponse deleteVeicolo(@RequestBody DeleteVeicoloRequestDTO veicoloToDelete) {
        return veicoloService.deleteVeicolo(veicoloToDelete);
    }
}
