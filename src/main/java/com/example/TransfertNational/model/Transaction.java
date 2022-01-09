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
    private String TypeTransfert;
    private boolean Notification;
    private Double FraitDonneur;
    private Double FraitBeneficiaire;
    private String NumTele;
    private Double Montant;
    private String NomBeneficiaire;
    private String PrenomBeneficiaire;
    private String NumGSMBeneficiaire;
    private String OTP;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private Date Date;
}
