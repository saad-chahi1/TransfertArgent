package com.example.TransfertNational.mapper;

import com.example.TransfertNational.dto.TransactionDto;
import com.example.TransfertNational.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {
    public static TransactionDto mapToDto(Transaction transaction) {

        TransactionDto transactionDto = TransactionDto.builder()
                .Date(transaction.getDate())
                .Montant(transaction.getMontant())
                .FraitBeneficiaire(transaction.getFraitBeneficiaire())
                .TypeTransfert(transaction.getTypeTransfert())
                .FraitDonneur(transaction.getFraitDonneur())
                .NomBeneficiaire(transaction.getNomBeneficiaire())
                .Notification(transaction.isNotification())
                .NumGSMBeneficiaire(transaction.getNumTele())
                .NumTele(transaction.getNumTele())
                .OTP(transaction.getOTP())
                .PrenomBeneficiaire(transaction.getPrenomBeneficiaire())
                .build();

        return transactionDto;

    }
    public static Transaction mapFromDto(TransactionDto transactionDto) {

        Transaction transaction = new Transaction();

        /*versement.setMontantVersement(versementDto.getMontantVersement());
        versement.setMotifVersement(versementDto.getMotifVersement());
        versement.setCompteBeneficiaire(compteBeneficiaire);
        versement.setDateExecution(versementDto.getDateExecution());
        versement.setNomEmetteur(versementDto.getNomEmetteur());*/

        return transaction;

    }

    public static List<TransactionDto> mapToListDto(List<Transaction> transactions){
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for(Transaction transaction : transactions){
            transactionDtos.add(TransactionMapper.mapToDto(transaction));
        }
        return transactionDtos;
    }

}
