package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.*;
import com.Team2Java12.MechAppoint.servicies.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCliente {
    private ClienteService clientiService;

    @Autowired
    public ControllerCliente(ClienteService clientiService) {
        this.clientiService = clientiService;
    }

    @PostMapping("/cliente/post") // ok testato
    public CreateClienteResponseDTO createCliente(@RequestBody CreateClienteRequestDTO request) {
        return clientiService.createCliente(request);
    }

    @GetMapping("/cliente/getAll") // ok testato
    public List<GetClienteResponseDTO> getAllCliente() {
        return clientiService.getAllClienti();
    }

    @GetMapping("/cliente/getClienteCompleto") // ok testato
    public GetClienteCompletoResponseDTO getClienteCompleto(@RequestParam Integer clienteId) {
        return clientiService.getClienteCompleto(clienteId);
    }

    @GetMapping("/cliente/get") // ok testato
    public GetClienteResponseDTO getCliente(@RequestParam Integer clienteId) {
        return clientiService.getCliente(clienteId);
    }

    @PutMapping("/cliente/put") // ok testato
    public BaseResponse putCliente(@RequestBody UpdateClienteRequestDTO request) {
        return clientiService.updateCliente(request);
    }

    @DeleteMapping("/cliente/delete") // ok testato
    public BaseResponse deleteCliente(@RequestBody DeleteClienteRequestDTO request) {
        return clientiService.deleteCliente(request);

    }
}
