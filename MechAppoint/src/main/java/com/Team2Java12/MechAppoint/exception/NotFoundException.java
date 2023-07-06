package com.Team2Java12.MechAppoint.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -0L;

    public NotFoundException(String message) {
        super(message);
    }
}
