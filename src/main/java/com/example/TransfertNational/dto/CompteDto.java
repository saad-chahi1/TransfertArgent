package com.example.TransfertNational.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompteDto {
    private String solde;
    private String rip;
}
