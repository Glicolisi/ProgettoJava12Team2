package com.Team2Java12.MechAppoint.repositories;

import com.Team2Java12.MechAppoint.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientiRepository extends JpaRepository<Cliente, Integer> {

}
