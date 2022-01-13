package com.example.TransfertNational.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BeneficiaireDto {
    private String nom;
    private String prenom;
    private String gsm;
}
