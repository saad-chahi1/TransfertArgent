package com.example.TransfertNational.service;

import com.example.TransfertNational.dto.TransactionDto;
import com.example.TransfertNational.exceptions.SoldeInsuffisantException;

import java.util.List;

public interface ITransactionService {
    List<TransactionDto> getTransactions();
    TransactionDto getTransaction(int Id);
    TransactionDto postTransaction(TransactionDto transactionDto) throws Exception, SoldeInsuffisantException;
}
