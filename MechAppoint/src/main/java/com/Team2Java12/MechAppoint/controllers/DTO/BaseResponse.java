package com.Team2Java12.MechAppoint.controllers.DTO;

import com.Team2Java12.MechAppoint.entities.ValidationEnum;

public class BaseResponse {
    private ValidationEnum status = ValidationEnum.OK;

    private String errorMessage;

    public ValidationEnum getStatus() {
        return status;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setStatus(ValidationEnum status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
