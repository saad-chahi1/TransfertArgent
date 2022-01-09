package com.example.TransfertNational.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Beneficiaire {
    private int Id;
    private String Nom;
    private String Prenom;
    private String GSM;
}
