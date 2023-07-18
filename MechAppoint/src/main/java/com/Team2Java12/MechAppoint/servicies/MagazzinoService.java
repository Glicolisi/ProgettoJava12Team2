package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotExistsException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Magazzino.*;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Magazzino;

import com.Team2Java12.MechAppoint.entities.Officina;
import com.Team2Java12.MechAppoint.repositories.MagazzinoRepository;

import com.Team2Java12.MechAppoint.repositories.OfficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MagazzinoService {

    @Autowired
    private MagazzinoRepository magazzinoRepository;
    @Autowired
    private OfficinaRepository officinaRepository;

    public BaseResponse createMagazzino(CreateMagazzinoRequestDTO magazzinoDTO) {
        Optional<Magazzino> oMagazzino = magazzinoRepository.findByNome(magazzinoDTO.getNomeMagazzino());
        if (oMagazzino.isPresent()) {
            throw new ConflictException("L'oggetto è gia stato creato");
        }
        Optional<Officina> oOfficina = officinaRepository.findById(magazzinoDTO.getOfficinaId());
        Magazzino magazzino = new Magazzino();
        Officina officina = oOfficina.orElseThrow(() -> new NotFoundException("Oggetto inesistente"));
        magazzino.setNome(magazzinoDTO.getNomeMagazzino());
        magazzino.setInventario(magazzinoDTO.getInventario());
        magazzino.setStatus(ValidationEnum.ACTIVE);
        magazzino.setOfficina(officina);
        magazzinoRepository.save(magazzino);
        BaseResponse baseResponse = new BaseResponse();
        return baseResponse;
    }

    public GetMagazzinoResponseDTO getMagazzino(Integer magazzinoId) {
        Optional<Magazzino> oMagazzino = magazzinoRepository.findById(magazzinoId);
        if (oMagazzino.isEmpty()) {
            throw new NotExistsException("Oggetto inesistente");
        }
        Magazzino magazzino = oMagazzino.get();
        GetMagazzinoResponseDTO getMagazzinoResponseDTO = new GetMagazzinoResponseDTO();
        getMagazzinoResponseDTO.setNome(magazzino.getNome());
        getMagazzinoResponseDTO.setValidation(magazzino.getStatus());
        return getMagazzinoResponseDTO;
    }

    public BaseResponse updateMagazzino(UpdateMagazzinoRequestDTO updateMagazzinoRequestDTO) {
        Optional<Magazzino> optionalMagazzino = magazzinoRepository.findById(updateMagazzinoRequestDTO.getId());
        if (optionalMagazzino.isEmpty()) {
            throw new RuntimeException();
        }
        Magazzino magazzino = optionalMagazzino.get();
        magazzino.setNome(updateMagazzinoRequestDTO.getNomeMagazzino());
        magazzino.setInventario(updateMagazzinoRequestDTO.getInventario());
        magazzinoRepository.save(magazzino);
        return new BaseResponse();
    }

    public BaseResponse deleteMagazzino(DeleteMagazzinoRequestDTO deleteMagazzinoRequestDTO) {
        Optional<Magazzino> optionalMagazzino = magazzinoRepository.findById(deleteMagazzinoRequestDTO.getId());
        if (optionalMagazzino.isEmpty()) {
            throw new RuntimeException();
        }
        Magazzino magazzino = optionalMagazzino.get();
        magazzino.setStatus(ValidationEnum.DELETED);
        magazzinoRepository.save(magazzino);

        return new BaseResponse();
    }
}

