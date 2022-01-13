package com.example.TransfertNational.service.Implementation;

import com.example.TransfertNational.dto.ClientDto;
import com.example.TransfertNational.mapper.ClientMapper;
import com.example.TransfertNational.model.Client;
import com.example.TransfertNational.repository.ClientRepository;
import com.example.TransfertNational.service.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
    public List<ClientDto> getClients() {
        List<Client> clients = clientRepository.findAll();
        return ClientMapper.mapToListDto(clients);
    }

    @Override
    public ClientDto getClient(int Id) {
        Client client = clientRepository.getById(Id);
        return ClientMapper.mapToDto(client);
    }

    @Override
    public ClientDto getClientByCin(String Cin) {
        Client client = clientRepository.findClientByCin(Cin);
        return ClientMapper.mapToDto(client);
    }

    @Override
    public ClientDto getClientByGsm(String Gsm) {
        Client client = clientRepository.findClientByGsm(Gsm);
        return ClientMapper.mapToDto(client);
    }

    @Override
    public ClientDto postClient(ClientDto clientDto) throws Exception {
        Client client = new Client();
        client.setTypeTransfert(clientDto.getTypeTransfert());
        client.setAdresseLegale(clientDto.getAdresseLegale());
        client.setBeneficiares(clientDto.getBeneficiares());
        client.setCin(clientDto.getCin());
        client.setEmail(clientDto.getEmail());
        client.setDateNaissance(clientDto.getDateNaissance());
        client.setGsm(clientDto.getGsm());
        client.setNumPI(clientDto.getNumPI());
        client.setNationalite(clientDto.getNationalite());
        client.setPaysAdresse(clientDto.getPaysAdresse());
        client.setPaysEmission(clientDto.getPaysEmission());
        client.setPrenom(clientDto.getPrenom());
        client.setProfession(clientDto.getProfession());
        client.setSexe(clientDto.getSexe());
        client.setVille(clientDto.getVille());
        client.setTypePiece(clientDto.getTypePiece());
        client.setTypePieceIdentite(clientDto.getTypePieceIdentite());
        client.setValiditePI(clientDto.getValiditePI());

        Client addedCr = clientRepository.save(client);
        return ClientMapper.mapToDto(addedCr);
    }
}
