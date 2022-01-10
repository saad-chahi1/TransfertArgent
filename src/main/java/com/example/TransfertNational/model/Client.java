package com.example.TransfertNational.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor @ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
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
    private String AdresseLegale;
    private String Solde;
    private String Ville;
    private String Gsm;
    private String Email;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Beneficiaire> Beneficiares;
}
