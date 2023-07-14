package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.*;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public CreateClienteResponseDTO createCliente(CreateClienteRequestDTO request) {
        Optional<Cliente> cliente = clienteRepository.findByUsername(request.getUsername());
        if (cliente.isPresent()) {
            throw new ConflictException("Username già esistente");
        }
        Cliente cliente1 = new Cliente(request.getUsername(), request.getPassword(), request.getEmail(), request.getCellulare(), request.getValidation());
        cliente1 = clienteRepository.save(cliente1);
        CreateClienteResponseDTO response = new CreateClienteResponseDTO();
        response.setId(cliente1.getId());
        response.setStatus(ValidationEnum.OK);
        return response;
    }

    public GetClienteResponseDTO getCliente(GetClienteRequestDTO get) {
        if (get == null) {
            throw new NotFoundException("Valore non inserito");
        }
        Cliente cliente = clienteRepository.findById(get.getId()).orElseThrow(() -> new NotFoundException("Id non trovato"));

        return new GetClienteResponseDTO(cliente.getId(), cliente.getUsername(), cliente.getPassword(), cliente.getEmail(), cliente.getCellulare(), cliente.getValidation().getStatus());
    }

    public BaseResponse updateCliente(UpdateClienteRequestDTO update) {
        Optional<Cliente> oCliente = clienteRepository.findByUsername(update.getUsername());
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();

            cliente.setUsername(update.getUsername());
            cliente.setPassword(update.getPassword());
            cliente.setEmail(update.getEmail());
            cliente.setCellulare(update.getCellulare());
            clienteRepository.save(cliente);
            return new BaseResponse();
        } else {
            throw new NotFoundException("Username non trovato");
        }
    }

    public BaseResponse deleteCliente(DeleteClienteRequestDTO delete) {
        Optional<Cliente> oCliente = clienteRepository.findById(delete.getId());
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();
            if (cliente.getValidation().equals(ValidationEnum.DELETED)) {
                throw new NotFoundException("Cliente già eliminato");
            } else {
                cliente.setValidation(ValidationEnum.DELETED);
                clienteRepository.save(cliente);
            }
        } else {
            throw new NotFoundException("Cliente non trovato");
        }
        return new BaseResponse();
    }
}
