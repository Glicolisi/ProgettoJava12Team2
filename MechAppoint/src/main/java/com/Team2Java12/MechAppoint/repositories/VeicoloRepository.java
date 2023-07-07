package com.Team2Java12.MechAppoint.repositories;

import com.Team2Java12.MechAppoint.entities.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, Integer> {
    Optional<Veicolo> findByTarga(String targa);
}
