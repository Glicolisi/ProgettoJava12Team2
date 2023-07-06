package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.controllers.DTO.CreateClienteRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.CreateClienteResponseDTO;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clientiRepository;

    public CreateClienteResponseDTO createCliente(CreateClienteRequestDTO request) {
        Optional<Cliente> cliente = clientiRepository.findByUsername(request.getUsername());
        if (cliente.isPresent()) {
            throw new ConflictException();}
            Cliente cliente1 = new Cliente(request.getUsername(), request.getPassword(), request.getEmail(),request.getCellulare(), request.getValidation());
            cliente1 = clientiRepository.save(cliente1);
            CreateClienteResponseDTO response = new CreateClienteResponseDTO();
            response.setId(cliente1.getId());
            response.setStatus(ValidationEnum.OK);
            return response;
        }

    public Cliente getCliente(Integer clienteId) {
        return clientiRepository.findById(clienteId).orElse(null);
    }

    public void updateCliente(Cliente cliente, Integer clienteId) {
        clientiRepository.deleteById(clienteId);
        clientiRepository.save(cliente);
    }

    public void deleteCliente(Integer Id) {
        clientiRepository.deleteById(Id);
    }
}
