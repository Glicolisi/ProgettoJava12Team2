package com.Team2Java12.MechAppoint.repositories;

import com.Team2Java12.MechAppoint.entities.Magazzino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazzinoRepository extends JpaRepository<Magazzino,Integer> {


    }

