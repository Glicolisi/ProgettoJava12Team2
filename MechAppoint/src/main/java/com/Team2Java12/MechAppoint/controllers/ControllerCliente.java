package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.service.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerCliente {
    private ClientiService clientiService;
    @Autowired
    public ControllerCliente(ClientiService clientiService) {
        this.clientiService = clientiService;
    }

    @PostMapping()
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente) {
        clientiService.createCliente(cliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping ("{ClienteId}")
    public ResponseEntity<Cliente> getCliente (@PathVariable ("ClientiId") Integer Id) {
        return ResponseEntity.ok(clientiService.getCliente(Id));
    }

    @PutMapping ({"ClienteId"})
    public ResponseEntity<?> putCliente (@RequestBody Cliente cliente, @PathVariable ("ClientiId") Integer Id) {
        clientiService.updateCliente(cliente, Id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("{ClienteId}")
    public ResponseEntity<?> deleteCliente (@PathVariable ("ClientiId") Integer Id) {
        clientiService.deleteCliente(Id);
        return ResponseEntity.ok().build();
    }
}
