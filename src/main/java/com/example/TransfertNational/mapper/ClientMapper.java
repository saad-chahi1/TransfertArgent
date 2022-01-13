package com.example.TransfertNational.mapper;

import com.example.TransfertNational.dto.ClientDto;
import com.example.TransfertNational.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {
    public static ClientDto mapToDto(Client client) {

        ClientDto clientDto = ClientDto.builder()
                .adresseLegale(client.getAdresseLegale())
                .beneficiares(client.getBeneficiares())
                .cin(client.getCin())
                .dateNaissance(client.getCin())
                .gsm(client.getGsm())
                .email(client.getEmail())
                .nationalite(client.getNationalite())
                .numPI(client.getNumPI())
                .paysAdresse(client.getPaysAdresse())
                .paysEmission(client.getPaysEmission())
                .prenom(client.getPrenom())
                .profession(client.getProfession())
                .sexe(client.getSexe())
                .typePiece(client.getTypePiece())
                .typeTransfert(client.getTypeTransfert())
                .typePieceIdentite(client.getTypePieceIdentite())
                .validitePI(client.getValiditePI())
                .ville(client.getVille())
                .comptePaiement(client.getComptePaiement())
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
