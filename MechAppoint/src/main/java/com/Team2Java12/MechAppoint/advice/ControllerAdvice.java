package com.Team2Java12.MechAppoint.advice;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.ForbiddenException;
import com.Team2Java12.MechAppoint.Exception.NotExistsException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.ControllerCliente;
import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = {ConflictException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public BaseResponse hanglingAlredyExist(ConflictException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(ValidationEnum.KO);
        br.setErrorMessage("RESOURCE_ALREADY_EXIST");
        return  br;
    }

    @ExceptionHandler(value = {ForbiddenException.class})
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public BaseResponse hanglingForbidden(ConflictException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(ValidationEnum.KO);
        br.setErrorMessage("RESOURCE_FORBIDDEN");
        return  br;
    }

    @ExceptionHandler(value = {NotExistsException.class})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public BaseResponse hanglingNotExists(ConflictException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(ValidationEnum.KO);
        br.setErrorMessage("RESOURCE_NOT_EXISTS");
        return  br;
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public BaseResponse hanglingNotFound(NotFoundException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(ValidationEnum.KO);
        br.setErrorMessage("RESOURCE_NOT_FOUND");
        return br;
    }

}
