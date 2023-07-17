package com.Team2Java12.MechAppoint.repositories;

import com.Team2Java12.MechAppoint.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {
    Optional<Prenotazione> findByNomeCliente(String nome);
    List<Prenotazione> findAllByNomeCliente(String nome);
}
