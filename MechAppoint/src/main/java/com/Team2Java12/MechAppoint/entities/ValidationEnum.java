package com.Team2Java12.MechAppoint.entities;

public enum ValidationEnum {

    ACTIVE ("Active"),
    DELETED ("Deleted"),
    OK ("Ok"),
    KO ("Ko");

    private String status;

    ValidationEnum (String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }

}
