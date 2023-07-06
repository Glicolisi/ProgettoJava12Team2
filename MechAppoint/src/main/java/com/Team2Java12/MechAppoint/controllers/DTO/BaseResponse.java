package com.Team2Java12.MechAppoint.controllers.DTO;

import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;

public class BaseResponse {

    private ValidationEnum status = ValidationEnum.OK;

    private String errorMessage;

    public ValidationEnum getStatus() {
        return status;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setStatus(ValidationEnum validationEnum) {
        this.status = validationEnum;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
