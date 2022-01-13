package com.example.TransfertNational.dto;

import com.example.TransfertNational.model.Beneficiaire;
import com.example.TransfertNational.model.ComptePaiement;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private String typeTransfert;
    private String typePiece;
    private String cin;

    private String sexe;
    private String prenom;
    private String typePieceIdentite;
    private String paysEmission;
    private String numPI;
    private String validitePI;
    private String dateNaissance;
    private String profession;
    private String nationalite;
    private String paysAdresse;
    private String adresseLegale;
    private String ville;
    private String gsm;
    private String email;

    private List<Beneficiaire> beneficiares;
    private ComptePaiement comptePaiement;
    
}