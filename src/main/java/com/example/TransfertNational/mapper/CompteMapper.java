package com.example.TransfertNational.mapper;

import com.example.TransfertNational.dto.ClientDto;
import com.example.TransfertNational.dto.CompteDto;
import com.example.TransfertNational.model.Client;
import com.example.TransfertNational.model.ComptePaiement;

import java.util.ArrayList;
import java.util.List;

public class CompteMapper {
    public static CompteDto mapToDto(ComptePaiement comptePaiement){
        CompteDto compteDto = CompteDto.builder()
                .rip(comptePaiement.getRip())
                .solde(comptePaiement.getSolde())
                .build();
        return compteDto;
    }
    public static List<CompteDto> mapToListDto(List<ComptePaiement> comptePaiements){
        List<CompteDto> compteDtos = new ArrayList<>();
        for(ComptePaiement compte : comptePaiements){
            compteDtos.add(CompteMapper.mapToDto(compte));
        }
        return compteDtos;
    }
}
