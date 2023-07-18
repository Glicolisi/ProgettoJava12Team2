package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotExistsException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.CreateClienteRequestDTO;
import com.Team2Java12.MechAppoint.controllers.DTO.Officina.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.CreatePrenotazioneRequestDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.PrenotazioneOfficinaDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.CreateVeicoloRequestDTO;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.entities.Officina;
import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.entities.Veicolo;
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


    public GetOfficinaResponseDto getOfficina(Integer idOfficina, String nomeOfficina) {
        Optional<Officina> optionalOfficina;
        if (idOfficina == null && nomeOfficina == null) {
            throw new NotFoundException("Campo di ricerca non inserito");
        } else if (nomeOfficina == null) {
            optionalOfficina=officinaRepository.findById(idOfficina);
        } else if (idOfficina == null) {
           optionalOfficina=officinaRepository.findByNome(nomeOfficina);
        } else if (!(nomeOfficina == null && idOfficina == null)){
            optionalOfficina=officinaRepository.findById(idOfficina);
        } else{
            throw new NotExistsException("Non esiste il campo richiesto");
        }
        Officina officina= optionalOfficina.orElseThrow(()-> new NotFoundException("Parametri non trovati"));
        GetOfficinaResponseDto get =  new GetOfficinaResponseDto(officina.getOfficinaid(), officina.getNome(), officina.getIndirizzo(), officina.getEmail(), officina.getValidation());

        for (Cliente cliente : officina.getClienti()){

            CreateClienteRequestDTO create = new CreateClienteRequestDTO();

            create.setUsername(cliente.getUsername());
            create.setPassword(cliente.getPassword());
            create.setEmail(cliente.getEmail());
            create.setCellulare(cliente.getCellulare());
            create.setValidation(cliente.getValidation());
            get.getCreateClienteRequestDTOList().add(create);
            for(Veicolo veicolo : cliente.getVeicoli()){

                CreateVeicoloRequestDTO requestDTO = new CreateVeicoloRequestDTO();

                requestDTO.setTipoVeicolo(veicolo.getTipoVeicolo());
                requestDTO.setTarga(veicolo.getTarga());
                requestDTO.setDataImmatricolazione(veicolo.getDataImmatricolazione());
                requestDTO.setId_cliente(veicolo.getId());
                get.getCreateVeicoloRequestDTOList().add(requestDTO);
            }

        }

        for (Prenotazione prenotazione : officina.getPrenotazioni()){
            PrenotazioneOfficinaDto create = new PrenotazioneOfficinaDto();
            create.setNomeCliente(prenotazione.getNomeCliente());
            create.setData(prenotazione.getData());
            create.setOrario(prenotazione.getOrario());
            create.setValidation(prenotazione.getValidation());
            get.getCreatePrenotazioneRequestDtoList().add(create);
        }

        get.setMagazzino(officina.getMagazzino());

        return get;
    }

    public BaseResponse updateOfficina(UpdateOfficinaRequestDto update){

        Optional<Officina> optionalOfficina = officinaRepository.findByNome(update.getNome());
        Officina officina = optionalOfficina.orElseThrow(()-> new NotExistsException("Parametri non trovati"));
        officina.setNome(update.getNomeSostituto());
        officina.setIndirizzo(update.getIndirizzo());
        officina.setEmail(update.getEmail());
        officinaRepository.save(officina);

        return  new BaseResponse();
    }

    public BaseResponse updateOfficinaClienti(UpdateOfficinaRequestClienteDto update){

        Optional<Officina> optionalOfficina = officinaRepository.findById(update.getOfficina_id());
        Officina officina = optionalOfficina.orElseThrow(()-> new NotExistsException("Parametri non trovati"));
        officina.setNome(update.getNomeSostituto());
        officina.setIndirizzo(update.getIndirizzo());
        officina.setEmail(update.getEmail());
        officina.getClienti().addAll(clienteRepository.findAllById(update.getCliente_id()));
        officina.getClienti().stream().forEach(m->m.getPrenotazioni().addAll(officina.getPrenotazioni()));
        officinaRepository.save(officina);

        return new BaseResponse();
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
