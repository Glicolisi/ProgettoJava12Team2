package com.Team2Java12.MechAppoint.servicies;

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

    public void createVeicolo (CreateVeicoloRequestDTO veicoloDTO) {
        Veicolo veicolo = new Veicolo();
        veicolo.setTipoVeicolo(veicoloDTO.getTipoVeicolo());
        veicolo.setDataImmatricolazione(veicoloDTO.getDataImmatricolazione());
        veicolo.setTarga(veicoloDTO.getTarga());
        veicolo.setProprietario(veicoloDTO.getProprietario());
        veicolo.setStatus(ValidationEnum.ACTIVE);
        veicoloRepository.save(veicolo);
    }

    public GetVeicoloDTO getVeicolo (Integer veicoloId) {
        Optional<Veicolo> oVeicolo = veicoloRepository.findById(veicoloId);
        if (oVeicolo.isPresent()) {
            Veicolo veicolo = oVeicolo.get();
            GetVeicoloDTO veicoloDTO = new GetVeicoloDTO();
            veicoloDTO.setTipoVeicolo(veicolo.getTipoVeicolo());
            veicoloDTO.setTarga(veicolo.getTarga());
            veicoloDTO.setDataImmatricolazione(veicolo.getDataImmatricolazione());
            veicoloDTO.setProprietario(veicolo.getCliente().getUsername());
            return veicoloDTO;
        } else {
            throw new NotFoundException("NOT_FOUND");
        }
    }

    public BaseResponse updateVeicolo (UpdateVeicoloRequestDTO veicoloToUpdate) {
        Optional<Veicolo> oVeicolo = veicoloRepository.findById(veicoloToUpdate.getId());
        if(oVeicolo.isEmpty()) {
            throw new RuntimeException();
        }
        Veicolo veicolo = oVeicolo.get();
        veicolo.setTarga(veicoloToUpdate.getTarga());
        veicolo.setTipoVeicolo(veicoloToUpdate.getTipoVeicolo());
        veicolo.setDataImmatricolazione(veicoloToUpdate.getDataImmatricolazione());
        veicoloRepository.save(veicolo);
        return new BaseResponse();
    }


    public BaseResponse deleteVeicolo (DeleteVeicoloRequestDTO veicoloToDelete) {
        Optional<Veicolo> oVeicolo = veicoloRepository.findById(veicoloToDelete.getId());
        if(oVeicolo.isEmpty()) {
            throw new RuntimeException();
        }
        Veicolo veicolo = oVeicolo.get();
        veicolo.setStatus(ValidationEnum.DELETED);
        veicoloRepository.save(veicolo);
        return new BaseResponse();
    }
}
