package com.example.TransfertNational.mapper;

import com.example.TransfertNational.dto.ClientDto;
import com.example.TransfertNational.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {
    public static ClientDto mapToDto(Client client) {

        ClientDto clientDto = ClientDto.builder()
                .AdresseLegale(client.getAdresseLegale())
                .Beneficiares(client.getBeneficiares())
                .Cin(client.getCin())
                .DateNaissance(client.getCin())
                .Gsm(client.getGsm())
                .Solde(client.getSolde())
                .Email(client.getEmail())
                .Nationalite(client.getNationalite())
                .NumPI(client.getNumPI())
                .PaysAdresse(client.getPaysAdresse())
                .PaysEmission(client.getPaysEmission())
                .Prenom(client.getPrenom())
                .Profession(client.getProfession())
                .Sexe(client.getSexe())
                .TypePiece(client.getTypePiece())
                .TypeTransfert(client.getTypeTransfert())
                .TypePieceIdentite(client.getTypePieceIdentite())
                .ValiditePI(client.getValiditePI())
                .Ville(client.getVille())
                .build();

        return clientDto;

    }

    public static List<ClientDto> mapToListDto(List<Client> clients){
        List<ClientDto> clientDtos = new ArrayList<>();
        for(Client client : clients){
            clientDtos.add(ClientMapper.mapToDto(client));
        }
        return clientDtos;
    }
}
