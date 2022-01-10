package com.example.TransfertNational.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data @Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Beneficiaire {
    @Id
    private int Id;
    private String Nom;
    private String Prenom;
    private String GSM;

}
