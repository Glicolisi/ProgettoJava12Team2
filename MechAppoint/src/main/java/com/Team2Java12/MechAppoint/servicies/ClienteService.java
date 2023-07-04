package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.controllers.DTO.ClienteDTO;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clientiRepository;

    public void createCliente(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            throw new IllegalArgumentException("Cliente non valido");
        }
        if (clienteDTO.getUsername() == null || clienteDTO.getUsername().isEmpty()) {
            throw new RuntimeException("Username is required");
        }
        if (clienteDTO.getPassword() == null || clienteDTO.getPassword().isEmpty()) {
            throw new RuntimeException("Password is required");
        }
        if (clienteDTO.getPassword().length() < 8) {
            throw new RuntimeException("Password must be at least 8 characters");
        }
        if (clienteDTO.getEmail() == null || clienteDTO.getEmail().isEmpty()) {
            throw new RuntimeException("Email is required");
        }
        if (clienteDTO.getCellulare() == null) {
            throw new RuntimeException("Cellulare is required");
        }
        Cliente cliente = new Cliente(
                clienteDTO.getId(),
                clienteDTO.getUsername(),
                clienteDTO.getPassword(),
                clienteDTO.getEmail(),
                clienteDTO.getCellulare()
        );
        clientiRepository.save(cliente);
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
