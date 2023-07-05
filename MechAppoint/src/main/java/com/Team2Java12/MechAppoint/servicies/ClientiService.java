package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.repositories.ClientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientiService {
    @Autowired
    private ClientiRepository clientiRepository;

    public void createCliente (Cliente cliente) {
        clientiRepository.save(cliente);
    }

    public Cliente getCliente (Integer clienteId) {
        return clientiRepository.findById(clienteId).orElse(null);
    }

    public void updateCliente (Cliente cliente, Integer clienteId) {
        clientiRepository.deleteById(clienteId);
        clientiRepository.save(cliente);
    }

    public void deleteCliente (Integer Id) {
        clientiRepository.deleteById(Id);
    }

}
