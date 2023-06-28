package com.Team2Java12.MechAppoint.servicies;


import com.Team2Java12.MechAppoint.entities.Magazzino;
import com.Team2Java12.MechAppoint.repositories.MagazzinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MagazzinoService {

    @Autowired
    private MagazzinoRepository magazzinoRepository;

    public void saveMagazzino(Magazzino magazzino){

        magazzinoRepository.save(magazzino);

    }

    public Magazzino getMagazzino (Integer magazzino_id){

        return magazzinoRepository.findById(magazzino_id).orElse(null);

    }

    public void updateMagazzino (Magazzino magazzino, Integer magazzino_id){

        magazzinoRepository.deleteById(magazzino_id);
        magazzinoRepository.save(magazzino);

    }

    public void deleteMagazzino (Integer magazzino_id){

        magazzinoRepository.deleteById(magazzino_id);

    }

}