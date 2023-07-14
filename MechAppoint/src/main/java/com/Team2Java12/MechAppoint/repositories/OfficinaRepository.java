package com.Team2Java12.MechAppoint.repositories;

import com.Team2Java12.MechAppoint.entities.Officina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface OfficinaRepository extends JpaRepository<Officina, Integer> {


    Optional<Officina> findByNome(String nome);
    //@Query (Hql) Native a true;
}
