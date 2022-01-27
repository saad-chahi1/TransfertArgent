package com.example.TransfertNational.service.implementation;

import com.example.TransfertNational.dto.CompteDto;
import com.example.TransfertNational.model.ComptePaiement;
import com.example.TransfertNational.repository.CompteRepository;
import com.example.TransfertNational.service.Implementation.CompteService;
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
class CompteServiceTest {
    @Mock
    private CompteRepository compteRepository;
    @InjectMocks
    private CompteService compteService;

    @Test
    void getComptes() {
        ComptePaiement compte1 = new ComptePaiement();
        compte1.setSolde("1230");
        compte1.setRip("00244546133435");

        ComptePaiement compte2 = new ComptePaiement();
        compte2.setSolde("5230");
        compte2.setRip("00324446133435");

        List<ComptePaiement> comptePaiements = Arrays.asList(compte1, compte2);
        Mockito.when(compteRepository.findAll()).thenReturn(comptePaiements);

        List<CompteDto> comptePaiementDtos = compteService.getComptes();
        assertEquals("1230", comptePaiementDtos.get(0).getSolde());
        assertEquals("00244546133435", comptePaiementDtos.get(0).getRip());
    }

    @Test
    void getCompte() {
    }

    @Test
    void postCompte() {
    }
}