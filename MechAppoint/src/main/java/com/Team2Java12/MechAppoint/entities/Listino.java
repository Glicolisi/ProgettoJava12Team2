package com.Team2Java12.MechAppoint.entities;

import java.util.HashMap;
import java.util.Map;

public class Listino {

    private String servizio;
    private Double prezzo;

    public Listino(String servizio, Double prezzo) {
        this.servizio = servizio;
        this.prezzo = prezzo;
    }
}
