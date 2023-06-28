package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.entities.Officina;
import com.Team2Java12.MechAppoint.repositories.OfficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OfficinaService {

    @Autowired
    private OfficinaRepository officinaRepository;

    public void saveOfficina (Officina officina){

        officinaRepository.save(officina);

    }

    public Officina getOfficina (Integer officinaid){

        return officinaRepository.findById(officinaid).orElse(null);

    }

    public void updateOfficina (Officina officina, Integer officinaid){

        officinaRepository.deleteById(officinaid);
        officinaRepository.save(officina);

    }

    public void deleteOfficina (Integer officinaid){

        officinaRepository.deleteById(officinaid);

    }

}
