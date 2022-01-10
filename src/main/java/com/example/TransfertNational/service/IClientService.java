package com.example.TransfertNational.service;

import com.example.TransfertNational.dto.ClientDto;

import java.util.List;

public interface IClientService {
    List<ClientDto> getClients();
    ClientDto getClient(int Id);
    ClientDto getClientByCin(String Cin);
    ClientDto getClientByGsm(String Gsm);
    ClientDto postClient(ClientDto clientDto) throws Exception;
}
