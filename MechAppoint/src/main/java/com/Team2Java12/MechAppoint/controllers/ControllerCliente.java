package com.Team2Java12.MechAppoint.controllers;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.*;
import com.Team2Java12.MechAppoint.servicies.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@Operation(summary = "Creazione di un Cliente")
    @PostMapping("/cliente/post") // ok testato
    public CreateClienteResponseDTO createCliente(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto con i campi di Cliente meno l'Id")
            @RequestBody CreateClienteRequestDTO request) {
        return clientiService.createCliente(request);
    }
@Operation(summary = "Lista completa di Clienti")
    @GetMapping("/cliente/getAll") // ok testato
    public List<GetClienteResponseDTO> getAllCliente() {
        return clientiService.getAllClienti();
    }
@Operation(summary = "Richiesta di un Cliente con i Veicoli, Prenotazioni e Officine correlate")
    @GetMapping("/cliente/getClienteCompleto") // ok testato
    public GetClienteCompletoResponseDTO getClienteCompleto(
            @Parameter (description = "Id del Cliente",required = true)
            @RequestParam Integer clienteId) {
        return clientiService.getClienteCompleto(clienteId);
    }
@Operation(summary = "Richiesta dei dettagli di un Cliente")
    @GetMapping("/cliente/get") // ok testato
    public GetClienteResponseDTO getCliente(
            @Parameter(description = "Id del Cliente", required = true)
            @RequestParam Integer clienteId) {
        return clientiService.getCliente(clienteId);
    }
@Operation(summary="Update di un Cliente")
    @PutMapping("/cliente/put") // ok testato
    public BaseResponse updateCliente(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto per aggiornare tutti i campi di un Cliente meno l'Id")
        @RequestBody UpdateClienteRequestDTO request) {
        return clientiService.updateCliente(request);
    }
@Operation(summary = "Cancellazione logica di un Cliente")
    @DeleteMapping("/cliente/delete") // ok testato
    public BaseResponse deleteCliente(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dto con l'Id del Cliente da eliminare")
            @RequestBody DeleteClienteRequestDTO request) {
        return clientiService.deleteCliente(request);

    }
}
