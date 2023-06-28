package com.Team2Java12.MechAppoint.repositories;

import com.Team2Java12.MechAppoint.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {
}
