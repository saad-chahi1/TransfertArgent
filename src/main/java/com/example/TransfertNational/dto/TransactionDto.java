package com.example.TransfertNational.dto;

import com.example.TransfertNational.model.Agent;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class TransactionDto {
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
    private Agent agent;
}
