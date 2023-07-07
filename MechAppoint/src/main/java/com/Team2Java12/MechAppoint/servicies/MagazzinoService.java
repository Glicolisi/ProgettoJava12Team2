package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Magazzino;

import com.Team2Java12.MechAppoint.repositories.MagazzinoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class MagazzinoService {

    @Autowired
    private MagazzinoRepository magazzinoRepository;

    public void createMagazzino(CreateMagazzinoRequestDTO magazzinoDTO) {
        Magazzino magazzino = new Magazzino();
        magazzino.setNomeOfficina(magazzinoDTO.getNomeOfficina());
        magazzino.setInventario(magazzinoDTO.getInventario());
        magazzino.setStatus(ValidationEnum.ACTIVE);
        magazzinoRepository.save(magazzino);
    }

    public GetMagazzinoDTO getMagazzino(Integer magazzinoId) {
        Optional<Magazzino> aMagazzino = magazzinoRepository.findById(magazzinoId);

        if (aMagazzino.isPresent()) {
            Magazzino magazzino = aMagazzino.get();
            GetMagazzinoDTO magazzinoDTO = new GetMagazzinoDTO();
            magazzinoDTO.setNomeOfficina(magazzino.getNomeOfficina());
            magazzinoDTO.getInventario(magazzino.getInventario());
            return magazzinoDTO;
        } else {
            throw new NotFoundException("NOT_FOUD");
        }

    }

    public BaseResponse updateMagazzino(UpdateMagazzinoRequestDTO updateMagazzinoRequestDTO) {
        Optional<Magazzino> optionalMagazzino = magazzinoRepository.findById(updateMagazzinoRequestDTO.getId());
        if (optionalMagazzino.isEmpty()) {
            throw new RuntimeException();
        }
        Magazzino magazzino = optionalMagazzino.get();
        magazzino.setNomeOfficina(updateMagazzinoRequestDTO.getNomeOfficina());
        magazzino.setInventario(updateMagazzinoRequestDTO.getInventario());
        magazzinoRepository.save(magazzino);
        return new BaseResponse();
    }

    public BaseResponse deleteMagazzino(DeletaMagazzinoRequestDTO deletaMagazzinoRequestDTO) {
        Optional<Magazzino> optionalMagazzino = magazzinoRepository.findById(deletaMagazzinoRequestDTO.getId());
        if (optionalMagazzino.isEmpty()) {
            throw new RuntimeException();
        }
        Magazzino magazzino = optionalMagazzino.get();
        magazzino.setStatus(ValidationEnum.DELETED);
        magazzinoRepository.save(magazzino);

        return new BaseResponse();
    }
}

