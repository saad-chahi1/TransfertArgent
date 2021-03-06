package com.example.TransfertNational.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Nom;
    private String Prenom;
    private String GSM;
    private String Mail;
    private String PW;
    private String Montant;
}
