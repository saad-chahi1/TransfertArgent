package com.example.TransfertNational.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
    private int Id;
    private String TypeTransfert;
    private String TypePiece;
    private String CIN;

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
    private String AdresseLegale;
    private String Ville;
    private String GSM;
    private String Email;

    private List<Beneficiaire> Beneficiares;
}
