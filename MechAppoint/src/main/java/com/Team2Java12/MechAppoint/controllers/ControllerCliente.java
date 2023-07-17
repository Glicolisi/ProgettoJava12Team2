package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.*;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.servicies.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCliente {
    private ClienteService clientiService;

    @Autowired
    public ControllerCliente(ClienteService clientiService) {
        this.clientiService = clientiService;
    }

    @PostMapping("/cliente/post")
    public CreateClienteResponseDTO createCliente(@RequestBody CreateClienteRequestDTO request) {
        return clientiService.createCliente(request); // testato
    }
    @GetMapping("/cliente/getAll")
    public List<GetClienteResponseDTO> getAllCliente() {
        return clientiService.getAllClienti();
    }
    @GetMapping("/cliente/getClienteCompleto")
    public GetClienteCompletoResponseDTO getClienteCompleto(@RequestParam Integer clienteId) {
        return clientiService.getClienteCompleto(clienteId);
    }

    @GetMapping("/cliente/get")
    public GetClienteResponseDTO getCliente(@RequestBody GetClienteRequestDTO request) {
        return clientiService.getCliente(request);
    }

    @PutMapping("/cliente/put")
    public BaseResponse putCliente(@RequestBody UpdateClienteRequestDTO request) {
        return clientiService.updateCliente(request);

    }

    @PutMapping("/cliente/setClienteprenotazione")
    public BaseResponse setClienteprenotazione(@RequestBody SetClienteRequestDto set){
        return clientiService.setClienteprenotazione(set);
    }

    @DeleteMapping("/cliente/delete")
    public BaseResponse deleteCliente(@RequestBody DeleteClienteRequestDTO request) {
        return clientiService.deleteCliente(request);

    }
}
