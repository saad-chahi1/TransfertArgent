package com.example.TransfertNational.service;

import com.example.TransfertNational.dto.ClientDto;

import java.util.List;

public interface IClientService {
    List<ClientDto> getClients();
    ClientDto getClient(int id);
    ClientDto getClientByCin(String cin);
    ClientDto getClientByGsm(String gsm);
    ClientDto postClient(ClientDto clientDto) throws Exception;
}
