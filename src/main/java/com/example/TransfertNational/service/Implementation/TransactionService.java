package com.example.TransfertNational.service.Implementation;

import com.example.TransfertNational.dto.TransactionDto;
import com.example.TransfertNational.mapper.TransactionMapper;
import com.example.TransfertNational.model.Transaction;
import com.example.TransfertNational.repository.TransactionRepository;
import com.example.TransfertNational.service.ITransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository=transactionRepository;
    }
    @Override
    public List<TransactionDto> getTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return TransactionMapper.mapToListDto(transactions);
    }

    @Override
    public TransactionDto getTransaction(int Id) {
        Transaction transaction = transactionRepository.getById(Id);
        return TransactionMapper.mapToDto(transaction);
    }

    @Override
    public TransactionDto postTransaction(TransactionDto transactionDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTypeTransfert(transactionDto.getTypeTransfert());
        transaction.setNotification(transactionDto.isNotification());
        transaction.setFraitDonneur(transactionDto.getFraitDonneur());
        transaction.setFraitBeneficiaire(transactionDto.getFraitBeneficiaire());
        transaction.setNumTele(transactionDto.getNumTele());
        transaction.setMontant(transactionDto.getMontant());
        transaction.setNomBeneficiaire(transactionDto.getNomBeneficiaire());
        transaction.setPrenomBeneficiaire(transactionDto.getPrenomBeneficiaire());
        transaction.setNumGSMBeneficiaire(transactionDto.getNumGSMBeneficiaire());
        transaction.setOTP(transactionDto.getOTP());
        transaction.setDate(transactionDto.getDate());

        Transaction addedTr = transactionRepository.save(transaction);
        return TransactionMapper.mapToDto(addedTr);
    }
}
