package com.Team2Java12.MechAppoint.repositories;

import com.Team2Java12.MechAppoint.entities.Officina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OfficinaRepository extends JpaRepository<Officina, Integer> {


}
