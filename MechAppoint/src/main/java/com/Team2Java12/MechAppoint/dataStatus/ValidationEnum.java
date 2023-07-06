package com.Team2Java12.MechAppoint.dataStatus;

public enum ValidationEnum {

    ACTIVE("Active"),
    DELETED("Deleted"),
    OK("OK"),
    KO("KO");

    private String status;

    ValidationEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
