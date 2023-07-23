package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotExistsException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.*;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.entities.Veicolo;
import com.Team2Java12.MechAppoint.repositories.ClienteRepository;
import com.Team2Java12.MechAppoint.repositories.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeicoloService {
    @Autowired
    private VeicoloRepository veicoloRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public CreateVeicoloResponseDTO createVeicolo (CreateVeicoloRequestDTO createVeicoloRequest) {
        Optional<Veicolo> oVeicolo = veicoloRepository.findByTarga(createVeicoloRequest.getTarga());
        Optional<Cliente> oCliente = clienteRepository.findById(createVeicoloRequest.getId_cliente());
        if (oVeicolo.isPresent()) {
            oVeicolo.orElseThrow(() -> new ConflictException("L'oggetto è gia stato creato"));
        }
        Veicolo veicolo = new Veicolo();
        Cliente cliente = oCliente.get();
        veicolo.setTipoVeicolo(createVeicoloRequest.getTipoVeicolo());
        veicolo.setDataImmatricolazione(createVeicoloRequest.getDataImmatricolazione());
        veicolo.setTarga(createVeicoloRequest.getTarga());
        veicolo.setCliente(cliente);
        veicolo.setValidation(createVeicoloRequest.getValidation());
        veicoloRepository.save(veicolo);
        CreateVeicoloResponseDTO createVeicoloResponse = new CreateVeicoloResponseDTO();
        createVeicoloResponse.setId(veicolo.getId());
        createVeicoloResponse.setStatus(ValidationEnum.OK);
        return createVeicoloResponse;
    }

    public GetVeicoloResponseDTO getVeicolo (Integer veicoloId, String veicoloTarga) {
        Optional<Veicolo> oVeicolo;
        if (veicoloTarga.equals(null) && veicoloId == null) {
            throw new NotFoundException("Nessun parametro inserito");
        } else if (veicoloTarga.equals(null)) {
            oVeicolo = veicoloRepository.findById(veicoloId);
        } else if (veicoloId == null) {
            oVeicolo = veicoloRepository.findByTarga(veicoloTarga);
        } else {
            oVeicolo = veicoloRepository.findById(veicoloId);
        }
        if (oVeicolo.isEmpty()) {
            throw new NotExistsException("Oggetto inesistente");
        }
            Veicolo veicolo = oVeicolo.get();
            GetVeicoloResponseDTO getVeicoloResponse = new GetVeicoloResponseDTO();
            getVeicoloResponse.setTipoVeicolo(veicolo.getTipoVeicolo());
            getVeicoloResponse.setTarga(veicolo.getTarga());
            getVeicoloResponse.setDataImmatricolazione(veicolo.getDataImmatricolazione());
            return getVeicoloResponse;
    }

    public BaseResponse updateVeicolo (UpdateVeicoloRequestDTO UpdateVeicoloRequest) {
        Optional<Veicolo> oVeicolo = veicoloRepository.findById(UpdateVeicoloRequest.getId());
        if(oVeicolo.isEmpty()) {
            throw new NotFoundException("Oggetto inesistente");
        }
        Veicolo veicolo = oVeicolo.get();
        veicolo.setTarga(UpdateVeicoloRequest.getTarga());
        veicolo.setTipoVeicolo(UpdateVeicoloRequest.getTipoVeicolo());
        veicolo.setDataImmatricolazione(UpdateVeicoloRequest.getDataImmatricolazione());
        veicoloRepository.save(veicolo);
        return new BaseResponse();
    }


    public BaseResponse deleteVeicolo (DeleteVeicoloRequestDTO deleteVeicoloRequest) {
        Optional<Veicolo> oVeicolo = veicoloRepository.findById(deleteVeicoloRequest.getId());
        if(oVeicolo.isEmpty()) {
            throw new NotFoundException("Oggetto inesistente");
        }
        Veicolo veicolo = oVeicolo.get();
        veicolo.setValidation(ValidationEnum.DELETED);
        veicoloRepository.save(veicolo);
        return new BaseResponse();
    }
}
