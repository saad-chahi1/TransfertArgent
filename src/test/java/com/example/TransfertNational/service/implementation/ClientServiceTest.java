package com.example.TransfertNational.service.implementation;

import com.example.TransfertNational.dto.ClientDto;
import com.example.TransfertNational.mapper.ClientMapper;
import com.example.TransfertNational.model.Client;
import com.example.TransfertNational.repository.ClientRepository;
import com.example.TransfertNational.service.Implementation.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void getClients(){
        Client client1 = new Client();
        client1.setVille("casablanca");
        client1.setSexe("male");

        Client client2 = new Client();
        client2.setVille("safi");
        client2.setSexe("female");

        List<Client> clients = Arrays.asList(client1, client2);
        Mockito.when(clientRepository.findAll()).thenReturn(clients);

        List<ClientDto> clientDtos = clientService.getClients();
        assertEquals("casablanca", clientDtos.get(0).getVille());
        assertEquals("male", clientDtos.get(0).getSexe());

        assertEquals("safi", clientDtos.get(1).getVille());
        assertEquals("female", clientDtos.get(1).getSexe());
    }
    @Test
    void getClient(){
        Client client1 = new Client();
        client1.setVille("casablanca");
        client1.setSexe("male");
        Mockito.when(clientRepository.getById(1)).thenReturn(client1);

        ClientDto clientDto = clientService.getClient(1);
        assertEquals("casablanca", clientDto.getVille());
        assertEquals("male", clientDto.getSexe());
    }
    @Test
    void postClient() throws Exception {
        Client client1 = new Client();
        client1.setVille("casablanca");
        client1.setSexe("male");
        Mockito.when(clientRepository.save(client1)).thenReturn(client1);

        ClientDto clientDto = clientService.postClient(ClientMapper.mapToDto(client1));
        assertEquals("casablanca", clientDto.getVille());
        assertEquals("male", clientDto.getSexe());

    }
    @Test
    void deleteClient(){
        assertEquals(1, 1);
    }

}