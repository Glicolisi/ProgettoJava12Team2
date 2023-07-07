package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.CreateClienteRequestDTO;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.servicies.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerCliente {
    private ClienteService clientiService;
    @Autowired
    public ControllerCliente(ClienteService clientiService) {
        this.clientiService = clientiService;
    }

    @PostMapping("/postCliente")
    public ResponseEntity<CreateClienteRequestDTO> createCliente(@RequestBody CreateClienteRequestDTO cliente) {
        clientiService.createCliente(cliente);
        return ResponseEntity.ok(cliente);
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
