package com.example.TransfertNational.mapper;

import com.example.TransfertNational.dto.BeneficiaireDto;
import com.example.TransfertNational.model.Beneficiaire;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaireMapper {
    public static BeneficiaireDto mapToDto(Beneficiaire beneficiaire) {

        BeneficiaireDto beneficiaireDto = BeneficiaireDto.builder()
                .gsm(beneficiaire.getGsm())
                .prenom(beneficiaire.getPrenom())
                .nom(beneficiaire.getNom())
                .build();
        return beneficiaireDto;
    }

    public static List<BeneficiaireDto> mapToListDto(List<Beneficiaire> beneficiaires){
        List<BeneficiaireDto> beneficiaireDtos = new ArrayList<>();
        for(Beneficiaire beneficiaire : beneficiaires){
            beneficiaireDtos.add(BeneficiaireMapper.mapToDto(beneficiaire));
        }
        return beneficiaireDtos;
    }
}
