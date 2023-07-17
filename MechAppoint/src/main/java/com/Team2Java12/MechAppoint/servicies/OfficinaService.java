package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotExistsException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Officina.*;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.entities.Officina;
import com.Team2Java12.MechAppoint.repositories.ClienteRepository;
import com.Team2Java12.MechAppoint.repositories.OfficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service

public class OfficinaService {

    @Autowired
    private OfficinaRepository officinaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Value("${app.feature.enablephysicaldeletion}")
    private boolean enablephysicaldeletion;

    //TODO:Gestire relazione Prenotazione-Cliente

    public CreateOfficinaResponseDto createOfficina (CreateOfficinaRequestDto request){

       Optional<Officina> optionalOfficina = officinaRepository.findByNome(request.getNome());
       if(optionalOfficina.isPresent()){
           optionalOfficina.orElseThrow(() -> new ConflictException("L'oggetto è gia stato creato"));
       }
       Officina officina = new Officina(request.getNome(), request.getIndirizzo(), request.getEmail(), request.getValidation());
       officina=officinaRepository.save(officina);
       CreateOfficinaResponseDto createOfficinaResponseDto = new CreateOfficinaResponseDto();
       createOfficinaResponseDto.setId(officina.getOfficinaid());
       createOfficinaResponseDto.setStatus(ValidationEnum.OK);
       return createOfficinaResponseDto;

    }


    public GetOfficinaResponseDto getOfficina(Integer id_officina, String nome_officina) {
        Optional<Officina> optionalOfficina;
        if (id_officina == null && nome_officina == null) {
            throw new NotFoundException("Campo di ricerca non inserito");
        } else if (nome_officina == null) {
            optionalOfficina=officinaRepository.findById(id_officina);
        } else if (id_officina == null) {
           optionalOfficina=officinaRepository.findByNome(nome_officina);
        } else if (!(nome_officina == null && id_officina == null)){
            optionalOfficina=officinaRepository.findById(id_officina);
        } else{
            throw new NotExistsException("Non esiste il campo richiesto");
        }

        Officina officina= optionalOfficina.orElseThrow(()-> new NotFoundException("Parametri non trovati"));
        return  new GetOfficinaResponseDto(officina.getOfficinaid(), officina.getNome(), officina.getIndirizzo(), officina.getEmail(), officina.getValidation());

    }

    public BaseResponse updateOfficina(UpdateOfficinaRequestDto update){

        Optional<Officina> optionalOfficina = officinaRepository.findByNome(update.getNome());
        Officina officina = optionalOfficina.orElseThrow(()-> new NotFoundException("Parametri non trovati"));
        officina.setNome(update.getNomeSostituto());
        officina.setIndirizzo(update.getIndirizzo());
        officina.setEmail(update.getEmail());
        officinaRepository.save(officina);

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
