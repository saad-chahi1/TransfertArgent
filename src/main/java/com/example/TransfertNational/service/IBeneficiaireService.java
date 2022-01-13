package com.example.TransfertNational.service;

import com.example.TransfertNational.dto.BeneficiaireDto;

import java.util.List;

public interface IBeneficiaireService {
    List<BeneficiaireDto> getBeneficiaires();
    BeneficiaireDto getBeneficiaire(int id);
    BeneficiaireDto postBeneficiaire(BeneficiaireDto beneficiaireDto)throws Exception;
}
