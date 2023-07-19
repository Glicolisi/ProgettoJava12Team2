package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.NotExistsException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.*;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.entities.Officina;
import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.repositories.ClienteRepository;
import com.Team2Java12.MechAppoint.repositories.OfficinaRepository;
import com.Team2Java12.MechAppoint.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private OfficinaRepository officinaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public CreatePrenotazioneResponseDto createPrenotazione (CreatePrenotazioneRequestDto request) {

        Optional<Cliente> oCliente = clienteRepository.findById(request.getClienteId());
        if (oCliente.isEmpty()) {
            throw new NotFoundException("id non trovato");
        }
        Optional<Officina> oOfficina = officinaRepository.findById(request.getOfficinaid());
        if (oOfficina.isEmpty()) {
            throw new NotFoundException("Officina inesistente");
        }
        Cliente cliente = oCliente.get();
        Officina officina = oOfficina.get();
        Prenotazione prenotazione = new Prenotazione(
                request.getNomeCliente(),
                request.getData(),
                request.getOrario());
        prenotazione.setCliente(cliente);
        prenotazione.setValidation(ValidationEnum.ACTIVE);
        prenotazione.setOfficina(officina);
        cliente.getPrenotazioni().add(prenotazione);
        cliente.getOfficine().add(officina);
        prenotazioneRepository.save(prenotazione);
        clienteRepository.save(cliente);

        CreatePrenotazioneResponseDto createPrenotazioneResponseDto = new CreatePrenotazioneResponseDto();
        createPrenotazioneResponseDto.setId(prenotazione.getPrenotazioneid());
        createPrenotazioneResponseDto.setStatus(ValidationEnum.OK);
        return createPrenotazioneResponseDto;

    }

    public GetPrenotazioneResponseDto getPrenotazioneResponseDto (Integer prenotazioneId) {
        Optional<Prenotazione> optionalPrenotazione;
        if (prenotazioneId == null) {
            throw new NotFoundException("Campo di ricerca non inserito");
        } else {
            optionalPrenotazione = prenotazioneRepository.findById(prenotazioneId);
            if (optionalPrenotazione.isEmpty()) {
                throw new NotFoundException("Parametri non trovati");
            }
        }

        Prenotazione prenotazione = optionalPrenotazione.get();
        return new GetPrenotazioneResponseDto(prenotazione.getPrenotazioneid(), prenotazione.getNomeCliente(), prenotazione.getData(), prenotazione.getOrario(), prenotazione.getValidation());

    }

    public BaseResponse updatePrenotazione(UpdatePrenotazioneRequestDto updatePrenotazione) {

        if (updatePrenotazione.getId() == null) {
            throw new NotFoundException("Parametri non trovati");
        }
        Optional<Prenotazione> optionalPrenotazione = prenotazioneRepository.findById(updatePrenotazione.getId());
        if (optionalPrenotazione.isEmpty()) {
            throw new NotExistsException("Oggetto inesistente");
        }
        Prenotazione prenotazione = optionalPrenotazione.get();
        prenotazione.setData(updatePrenotazione.getData());
        prenotazione.setOrario(updatePrenotazione.getOrario());
        prenotazioneRepository.save(prenotazione);
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

