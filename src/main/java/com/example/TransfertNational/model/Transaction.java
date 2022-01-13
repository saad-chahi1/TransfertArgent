package com.example.TransfertNational.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String typeTransfert;
    private boolean notification;
    private Double fraitTransfert;
    private String cin;
    private String numTele;
    private Double montant;
    private String nomBeneficiaire;
    private String prenomBeneficiaire;
    private String numGSMBeneficiaire;
    private String otp;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private Date date;
    private String status;
    @OneToOne(targetEntity=Agent.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Agent agent;
}
