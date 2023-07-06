package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.controllers.DTO.CreateMagazzinoRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.GetMagazzinoDTO;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Magazzino;

import com.Team2Java12.MechAppoint.repositories.MagazzinoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class MagazzinoService{

    @Autowired
    private MagazzinoRepository magazzinoRepository;

    public void createMagazzino (CreateMagazzinoRequestDTO magazzinoDTO) {
        Magazzino magazzino=new Magazzino();
        magazzino.setNomeOfficina(magazzinoDTO.getNomeOfficina());
        magazzino.setInventario(magazzinoDTO.getInventario());
        magazzino.setStatus(ValidationEnum.ACTIVE);
        magazzinoRepository.save(magazzino);
    }

    public GetMagazzinoDTO getMagazzino (Integer magazzinoId) {
        Optional<Magazzino>aMagazzino=magazzinoRepository.findById(magazzinoId);

         if(aMagazzino.isPresent()){
             Magazzino magazzino=aMagazzino.get();
             GetMagazzinoDTO magazzinoDTO=new GetMagazzinoDTO();
             magazzinoDTO.setNomeOfficina(magazzino.getNomeOfficina())
             ;
         }
    }

    public void updateMagazzino (Magazzino magazzino, Integer magazzinoId) {
        magazzinoRepository.deleteById(magazzinoId);
        magazzinoRepository.save(magazzino);
    }

    public void deleteMagazzino (Integer Id) {
        magazzinoRepository.deleteById(Id);
    }
}