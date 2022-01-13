package com.example.TransfertNational.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComptePaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String solde;
    private String rip;
}
