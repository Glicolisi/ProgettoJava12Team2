package com.Team2Java12.MechAppoint.servicies;

import com.Team2Java12.MechAppoint.Exception.ConflictException;
import com.Team2Java12.MechAppoint.Exception.NotFoundException;
import com.Team2Java12.MechAppoint.controllers.DTO.BaseResponse;
import com.Team2Java12.MechAppoint.controllers.DTO.Cliente.*;
import com.Team2Java12.MechAppoint.controllers.DTO.Prenotazione.GetPrenotazioneResponseDto;
import com.Team2Java12.MechAppoint.controllers.DTO.Veicolo.GetVeicoloResponseDTO;
import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import com.Team2Java12.MechAppoint.entities.Cliente;
import com.Team2Java12.MechAppoint.entities.Officina;
import com.Team2Java12.MechAppoint.entities.Prenotazione;
import com.Team2Java12.MechAppoint.entities.Veicolo;
import com.Team2Java12.MechAppoint.repositories.ClienteRepository;
import com.Team2Java12.MechAppoint.repositories.OfficinaRepository;
import com.Team2Java12.MechAppoint.repositories.PrenotazioneRepository;
import com.Team2Java12.MechAppoint.repositories.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VeicoloRepository veicoloRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private OfficinaRepository officinaRepository;

    public CreateClienteResponseDTO createCliente(CreateClienteRequestDTO request) {
        Optional<Cliente> cliente = clienteRepository.findByUsername(request.getUsername());
        if (cliente.isPresent()) {
            throw new ConflictException("Username già esistente");
        }
        Cliente cliente1 = new Cliente(request.getUsername(), request.getPassword(), request.getEmail(), request.getCellulare(), request.getValidation());
        cliente1 = clienteRepository.save(cliente1);
        CreateClienteResponseDTO response = new CreateClienteResponseDTO();
        response.setId(cliente1.getId());
        response.setStatus(ValidationEnum.OK);
        return response;
    }
    public GetClienteResponseDTO getCliente(GetClienteRequestDTO get) {
        if (get == null) {
            throw new NotFoundException("Valore non inserito");
        }
        Cliente cliente = clienteRepository.findById(get.getId()).orElseThrow(() -> new NotFoundException("Id non trovato"));

        return new GetClienteResponseDTO(cliente.getId(), cliente.getUsername(), cliente.getPassword(), cliente.getEmail(), cliente.getCellulare(), cliente.getValidation().getStatus());
    }

    public GetClienteCompletoResponseDTO getClienteCompleto (Integer clienteId){
        if (clienteId == null) {
            throw new NotFoundException("Valore non inserito");
        }
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new NotFoundException("Id cliente non trovato"));
        GetClienteResponseDTO clienteResponseDTO = new GetClienteResponseDTO(cliente.getId(), cliente.getUsername(), cliente.getPassword(), cliente.getEmail(), cliente.getCellulare(), cliente.getValidation().getStatus());

        List<GetVeicoloResponseDTO> veicoli =new ArrayList<>();
        for (Veicolo veicolo : cliente.getVeicoli()) {
            GetVeicoloResponseDTO veicoloDTO = new GetVeicoloResponseDTO();
            veicoloDTO.setTipoVeicolo(veicolo.getTipoVeicolo());
            veicoloDTO.setProprietario(veicolo.getProprietario());
            veicoloDTO.setTarga(veicolo.getTarga());
            veicoloDTO.setDataImmatricolazione(veicolo.getDataImmatricolazione());
            veicoloDTO.setValidation(veicolo.getValidation());
            veicoli.add(veicoloDTO);
        }

        List<GetPrenotazioneResponseDto> prenotazioni = new ArrayList<>();
        /*cliente.getPrenotazioni().stream().map(prenotazione ->
                new GetPrenotazioneResponseDto(prenotazione.getId(),
                        prenotazione.getNomeCliente(),
                        prenotazione.getData(),
                        prenotazione.getOrario(),
                        prenotazione.getValidation())).forEach(prenotazioni::add);*/
        for (Prenotazione prenotazione : cliente.getPrenotazioni()) {
            GetPrenotazioneResponseDto prenotazioneDTO = new GetPrenotazioneResponseDto();
            prenotazioneDTO.setId(prenotazione.getId());
            prenotazioneDTO.setNomeCliente(prenotazione.getNomeCliente());
            prenotazioneDTO.setData(prenotazione.getData());
            prenotazioneDTO.setOrario(prenotazione.getOrario());
            prenotazioneDTO.setValidation(prenotazione.getValidation());
            prenotazioni.add(prenotazioneDTO);
        }


        GetClienteCompletoResponseDTO response = new GetClienteCompletoResponseDTO();
        response.setCliente(clienteResponseDTO);
        response.setVeicoli(veicoli);
        response.setPrenotazioni(prenotazioni);
        return response;
    }
    public List<GetClienteResponseDTO> getAllClienti() {
        List<Cliente> clienti = clienteRepository.findAll();
        List<GetClienteResponseDTO> response = new ArrayList<>();
        for (Cliente cliente : clienti) {
            response.add(new GetClienteResponseDTO(cliente.getId(),
                    cliente.getUsername(),
                    cliente.getPassword(),
                    cliente.getEmail(), cliente.getCellulare(),
                    cliente.getValidation().getStatus()));
        }

        return response;
    }

    public BaseResponse updateCliente(UpdateClienteRequestDTO update) {
        Optional<Cliente> oCliente = clienteRepository.findByUsername(update.getUsername());
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();

            cliente.setUsername(update.getUsername());
            cliente.setPassword(update.getPassword());
            cliente.setEmail(update.getEmail());
            cliente.setCellulare(update.getCellulare());
            clienteRepository.save(cliente);
            return new BaseResponse();
        } else {
            throw new NotFoundException("Username non trovato");
        }
    }

    public BaseResponse setClienteprenotazione(SetClienteRequestDto set) {

        Optional<Cliente> oCliente = clienteRepository.findById(set.getCliente_id());
        if (oCliente.isEmpty()) {
            throw new NotFoundException("id non trovato");
        }
        Cliente cliente = oCliente.get();
        Prenotazione prenotazione = new Prenotazione(
                set.getCreatePrenotazioneRequestDto().getNomeCliente(),
                set.getCreatePrenotazioneRequestDto().getData(),
                set.getCreatePrenotazioneRequestDto().getOrario());
        prenotazione.setCliente(cliente);
        prenotazione.setValidation(ValidationEnum.ACTIVE);
        Optional<Officina> oOfficina = officinaRepository.findById(set.getOfficina_id());
        if(oOfficina.isEmpty()){
            throw new NotFoundException("Officina inesistente");
        }
        Officina officina = oOfficina.get();
        prenotazione.setOfficina(officina);
        cliente.getPrenotazioni().add(prenotazione);
        cliente.getOfficine().add(officina);
        prenotazioneRepository.save(prenotazione);
        clienteRepository.save(cliente);


        return new BaseResponse();
    }

    public BaseResponse deleteCliente(DeleteClienteRequestDTO delete) {
        Optional<Cliente> oCliente = clienteRepository.findById(delete.getId());
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();
            if (cliente.getValidation().equals(ValidationEnum.DELETED)) {
                throw new NotFoundException("Cliente già eliminato");
            } else {
                cliente.setValidation(ValidationEnum.DELETED);
                clienteRepository.save(cliente);
            }
        } else {
            throw new NotFoundException("Cliente non trovato");
        }
        return new BaseResponse();
    }
}
