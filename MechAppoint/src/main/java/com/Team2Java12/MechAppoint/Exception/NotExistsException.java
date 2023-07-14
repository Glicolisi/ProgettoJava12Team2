package com.Team2Java12.MechAppoint.Exception;

public class NotExistsException extends RuntimeException  {

    private static final long serialVersionUID = -2L;
    public NotExistsException (String message) {
        super(message);
    }

}
