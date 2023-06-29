package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.entities.Magazzino;

import com.Team2Java12.MechAppoint.repositories.MagazzinoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MagazzinoService{

    @Autowired
    private MagazzinoRepository magazzinoRepository;

    public void createMagazzino (Magazzino magazzino) {
        magazzinoRepository.save(magazzino);
    }

    public Magazzino getMagazzino (Integer magazzinoId) {
        return magazzinoRepository.findById(magazzinoId).orElse(null);
    }

    public void updateMagazzino (Magazzino magazzino, Integer magazzinoId) {
        magazzinoRepository.deleteById(magazzinoId);
        magazzinoRepository.save(magazzino);
    }

    public void deleteMagazzino (Integer Id) {
        magazzinoRepository.deleteById(Id);
    }
}