package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Veicolo;
import com.Team2Java12.MechAppoint.repositories.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeicoloService {
    @Autowired
    private VeicoloRepository veicoloRepository;

    public CreateVeicoloResponseDTO createVeicolo (CreateVeicoloRequestDTO createVeicoloRequest) {
        Optional<Veicolo> oVeicolo = veicoloRepository.findByTarga(createVeicoloRequest.getTarga());
        if (oVeicolo.isPresent()) {
            oVeicolo.orElseThrow(() -> new ConflictException());
        }
        Veicolo veicolo = new Veicolo();
        veicolo.setTipoVeicolo(createVeicoloRequest.getTipoVeicolo());
        veicolo.setDataImmatricolazione(createVeicoloRequest.getDataImmatricolazione());
        veicolo.setTarga(createVeicoloRequest.getTarga());
        veicolo.setProprietario(createVeicoloRequest.getProprietario());
        veicolo.setStatus(ValidationEnum.ACTIVE);
        veicoloRepository.save(veicolo);
        CreateVeicoloResponseDTO createVeicoloResponse = new CreateVeicoloResponseDTO();
        createVeicoloResponse.setId(veicolo.getId());
        createVeicoloResponse.setStatus(ValidationEnum.OK);
        return createVeicoloResponse;
    }

    public GetVeicoloResponseDTO getVeicolo (GetVeicoloRequestDTO getVeicoloRequest) {
        Optional<Veicolo> oVeicolo;
        if (getVeicoloRequest.getTarga().isEmpty() && getVeicoloRequest.getId() == null) {
            throw new NotFoundException("Nessun parametro inserito");
        } else if (getVeicoloRequest.getTarga().isEmpty()) {
            oVeicolo = veicoloRepository.findById(getVeicoloRequest.getId());
        } else if (getVeicoloRequest.getId() == null) {
            oVeicolo = veicoloRepository.findByTarga(getVeicoloRequest.getTarga());
        } else {
            oVeicolo = veicoloRepository.findById(getVeicoloRequest.getId());
        }
        if (oVeicolo.isEmpty()) {
            throw new NotFoundException("Oggetto non trovato");
        }
            Veicolo veicolo = oVeicolo.get();
            GetVeicoloResponseDTO getVeicoloResponse = new GetVeicoloResponseDTO();
            getVeicoloResponse.setTipoVeicolo(veicolo.getTipoVeicolo());
            getVeicoloResponse.setTarga(veicolo.getTarga());
            getVeicoloResponse.setDataImmatricolazione(veicolo.getDataImmatricolazione());
            getVeicoloResponse.setProprietario(veicolo.getCliente().getUsername());
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
        veicolo.setStatus(ValidationEnum.DELETED);
        veicoloRepository.save(veicolo);
        return new BaseResponse();
    }
}
