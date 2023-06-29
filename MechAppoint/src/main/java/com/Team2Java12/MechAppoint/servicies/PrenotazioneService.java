package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PrenotazioneService {

        @Autowired
        private PrenotazioneRepository prenotazioneRepository;

        public void createPrenotazione (Prenotazione prenotazione) {
            prenotazioneRepository.save(prenotazione);
        }

        public Prenotazione getPrenotazione (Integer prenotazioneId) {
            return prenotazioneRepository.findById(prenotazioneId).orElse(null);
        }

        public void updatePrenotazione (Prenotazione prenotazione, Integer prenotazioneId) {
            prenotazioneRepository.deleteById(prenotazioneId);
            prenotazioneRepository.save(prenotazione);
        }

        public void deletePrenotazione (Integer Id) {
            prenotazioneRepository.deleteById(Id);
        }
    }

