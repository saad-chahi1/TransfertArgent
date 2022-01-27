package com.example.TransfertNational.service.implementation;

import com.example.TransfertNational.dto.BeneficiaireDto;
import com.example.TransfertNational.model.Beneficiaire;
import com.example.TransfertNational.repository.BeneficiaireRepository;
import com.example.TransfertNational.service.Implementation.BeneficiaireService;
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
class BeneficiaireServiceTest {
    @Mock
    private BeneficiaireRepository beneficiaireRepository;
    @InjectMocks
    private BeneficiaireService beneficiaireService;

    @Test
    void getBeneficiaires() {
        Beneficiaire beneficiaire1 = new Beneficiaire();
        beneficiaire1.setNom("chahi");
        beneficiaire1.setPrenom("saad");

        Beneficiaire beneficiaire2 = new Beneficiaire();
        beneficiaire2.setNom("chahi");
        beneficiaire2.setPrenom("saad");

        List<Beneficiaire> beneficiaires = Arrays.asList(beneficiaire1, beneficiaire2);
        Mockito.when(beneficiaireRepository.findAll()).thenReturn(beneficiaires);

        List<BeneficiaireDto> beneficiaireDtos = beneficiaireService.getBeneficiaires();
        assertEquals("chahi", beneficiaireDtos.get(0).getNom());
        assertEquals("saad", beneficiaireDtos.get(0).getPrenom());
    }

    @Test
    void getBeneficiaire() {
    }

    @Test
    void postBeneficiaire() {
    }
}