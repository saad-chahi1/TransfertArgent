package com.example.TransfertNational.dto;

import com.example.TransfertNational.model.Beneficiaire;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class ClientDto {
    private String TypeTransfert;
    private String TypePiece;
    private String Cin;

    private String Sexe;
    private String Prenom;
    private String TypePieceIdentite;
    private String PaysEmission;
    private String NumPI;
    private String ValiditePI;
    private String DateNaissance;
    private String Profession;
    private String Nationalite;
    private String PaysAdresse;
    private String Solde;
    private String AdresseLegale;
    private String Ville;
    private String Gsm;
    private String Email;

    private Set<Beneficiaire> Beneficiares;
    
}