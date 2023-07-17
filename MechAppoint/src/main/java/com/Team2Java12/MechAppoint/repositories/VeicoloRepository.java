package com.Team2Java12.MechAppoint.repositories;

import com.Team2Java12.MechAppoint.entities.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, Integer> {
    Optional<Veicolo> findByTarga(String targa);
    Veicolo findByClienteUsername(String username);
    List<Veicolo> findAllByClienteUsername(String username);
    List<Veicolo> findAllByClienteId(Integer id);

   // @Query(value = "SELECT * FROM Veicoli WHERE proprietario = ?1", nativeQuery = true)
    //List<Veicolo> findAllByClienteUsername(String username);
}
