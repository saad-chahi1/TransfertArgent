package com.example.TransfertNational.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class TransactionDto {
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
