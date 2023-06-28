package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione (Prenotazione prenotazione){

        prenotazioneRepository.save(prenotazione);

    }

    public Prenotazione getPrenotazione (Integer prenotazione_id){

        return prenotazioneRepository.findById(prenotazione_id).orElse(null);

    }

    public void updatePrenotazione (Prenotazione prenotazione, Integer prenotazione_id){

        prenotazioneRepository.deleteById(prenotazione_id);
        prenotazioneRepository.save(prenotazione);

    }

    public void deletePrenotazione (Integer prenotazione_id){

        prenotazioneRepository.deleteById(prenotazione_id);

    }

}