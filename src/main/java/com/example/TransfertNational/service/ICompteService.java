package com.example.TransfertNational.service;

import com.example.TransfertNational.dto.CompteDto;

import java.util.List;

public interface ICompteService {
    List<CompteDto> getComptes();
    CompteDto getCompte(int id);
    CompteDto postCompte(CompteDto compteDto) throws Exception;
}
