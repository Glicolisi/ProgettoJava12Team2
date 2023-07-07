package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.*;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public CreatePrenotazioneResponseDto createPrenotazione (CreatePrenotazioneRequestDto request) {

        Optional<Prenotazione> optionalPrenotazione = prenotazioneRepository.findBynomeCliente(request.getNomeCliente());
        optionalPrenotazione.orElseThrow(() -> new ConflictException());
        Prenotazione prenotazione = new Prenotazione(request.getNomeCliente(), request.getData(), request.getOrario(), request.getValidation());
        prenotazione = prenotazioneRepository.save(prenotazione);
        CreatePrenotazioneResponseDto createPrenotazioneResponseDto = new CreatePrenotazioneResponseDto();
        createPrenotazioneResponseDto.setId(prenotazione.getId());
        createPrenotazioneResponseDto.setStatus(ValidationEnum.OK);
        return createPrenotazioneResponseDto;

    }

    public GetPrenotazioneResponseDto getPrenotazioneResponseDto (GetPrenotazioneRequestDto getrequest) {
        Optional<Prenotazione> optionalPrenotazione;
        if (getrequest.getNomeCliente().isEmpty() && getrequest.getId() == null) {
            throw new NotFoundException("Non hai inserito i campi richiesti");
        } else if (getrequest.getNomeCliente().isEmpty()) {
            optionalPrenotazione = prenotazioneRepository.findById(getrequest.getId());
        } else {
            optionalPrenotazione = prenotazioneRepository.findById(getrequest.getId());
        }

        Prenotazione prenotazione = optionalPrenotazione.orElseThrow(() -> new NotFoundException("Parametri non trovati"));
        return new GetPrenotazioneResponseDto(prenotazione.getId(), prenotazione.getNomeCliente(), prenotazione.getData(), prenotazione.getOrario(), prenotazione.getValidation());

    }

    public BaseResponse updatePrenotazione(UpdatePrenotazioneRequestDto updatePrenotazione) {

        Optional<Prenotazione> optionalPrenotazione = prenotazioneRepository.findBynomeCliente(updatePrenotazione.getNomeCliente());
        optionalPrenotazione.orElseThrow(() -> new ConflictException());
        Prenotazione prenotazione = optionalPrenotazione.orElseThrow(() -> new NotFoundException("Errore, non sono stati trovati i parametri"));
        prenotazione.setNomeCliente(updatePrenotazione.getNomeCliente());
        prenotazione.setData(updatePrenotazione.getData());
        prenotazione.setOrario(updatePrenotazione.getOrario());

        return new BaseResponse();
    }

    public BaseResponse deletePrenotazione(DeletePrenotazioneRequestDto deletePrenotazione) {
        Optional<Prenotazione> optionalPrenotazione = prenotazioneRepository.findById(deletePrenotazione.getId());
        if (optionalPrenotazione.isEmpty()) {
            throw new RuntimeException();
        }
        Prenotazione prenotazione = optionalPrenotazione.get();
        prenotazione.setValidation(ValidationEnum.DELETED);
        prenotazioneRepository.save(prenotazione);
        return new BaseResponse();
    }
}

