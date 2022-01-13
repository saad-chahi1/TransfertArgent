package com.example.TransfertNational.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor @ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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

    @OneToMany(targetEntity = Beneficiaire.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiare_id", referencedColumnName = "id")
    private List<Beneficiaire> beneficiares;

    @OneToOne(targetEntity = ComptePaiement.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "comptePaiement_id", referencedColumnName = "id")
    private ComptePaiement comptePaiement;
}
