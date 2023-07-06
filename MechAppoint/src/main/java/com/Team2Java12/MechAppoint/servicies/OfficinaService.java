package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.entities.Officina;
import com.Team2Java12.MechAppoint.entities.ValidationEnum;
import com.Team2Java12.MechAppoint.repositories.OfficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class OfficinaService {

    @Autowired
    private OfficinaRepository officinaRepository;

    @Value("${app.feature.enablephysicaldeletion}")
    private boolean enablephysicaldeletion;

    public CreateOfficinaResponseDto createOfficina (CreateOfficinaRequestDto request){

       Optional<Officina> optionalOfficina = officinaRepository.findByNome(request.getNome());
       if(optionalOfficina.isPresent()){
           optionalOfficina.orElseThrow(() -> new ConflictException());

       }
       Officina officina = new Officina(request.getNome(), request.getIndirizzo(), request.getEmail(), request.getValidation());
       officina=officinaRepository.save(officina);
       CreateOfficinaResponseDto createOfficinaResponseDto = new CreateOfficinaResponseDto();
       createOfficinaResponseDto.setId(officina.getOfficinaid());
       createOfficinaResponseDto.setStatus(ValidationEnum.OK);
       return createOfficinaResponseDto;

    }


    public GetOfficinaResponseDto getOfficina(GetOfficinaRequestDto get) {
        Optional<Officina> optionalOfficina;
        if (get.getNome().isEmpty() && get.getId() == null) {
            throw new NotFoundException("Campo di ricerca non inserito");
        } else if (get.getNome().isEmpty()) {
            optionalOfficina=officinaRepository.findById(get.getId());
        } else if (get.getId() == null) {
           optionalOfficina=officinaRepository.findByNome(get.getNome());
        } else {
            optionalOfficina=officinaRepository.findById(get.getId());
        }

        Officina officina= optionalOfficina.orElseThrow(()-> new NotFoundException("Parametri non trovati"));
        return  new GetOfficinaResponseDto(officina.getOfficinaid(), officina.getNome(), officina.getIndirizzo(), officina.getEmail(), officina.getValidation());

    }

    public BaseResponse updateOfficina(UpdateOfficinaRequestDto update){

        Optional<Officina> optionalOfficina = officinaRepository.findByNome(update.getNome());
        optionalOfficina.orElseThrow(() -> new ConflictException());
        Officina officina = optionalOfficina.orElseThrow(()-> new NotFoundException("Parametri non trovati"));
        officina.setNome(update.getNome());
        officina.setIndirizzo(update.getIndirizzo());
        officina.setEmail(update.getEmail());

        return  new BaseResponse();
    }


    public BaseResponse deleteOfficina (DeleteOfficinaRequestDto delete){

    Optional<Officina> optionalOfficina = officinaRepository.findById(delete.getId());
    if(optionalOfficina.isEmpty()){
        throw new RuntimeException("L'oggetto non esiste");
    }
    Officina officina = optionalOfficina.get();

        if(enablephysicaldeletion){
            officinaRepository.delete(officina);
        } else{
            officina.setValidation(ValidationEnum.DELETED);
            officinaRepository.save(officina);
        }
    BaseResponse baseResponse = new BaseResponse();
    baseResponse.setStatus(ValidationEnum.OK);
    return baseResponse;

    }



}
