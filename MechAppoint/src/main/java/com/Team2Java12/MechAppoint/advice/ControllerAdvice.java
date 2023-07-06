package com.Team2Java12.MechAppoint.advice;

import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public BaseResponse hanglingNotFound(NotFoundException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(ValidationEnum.KO);
        br.setErrorMessage("RESOURCE_NOT_FOUND");
        return br;
    }

}
