package com.example.TransfertNational.service.implementation;

import com.example.TransfertNational.dto.TransactionDto;
import com.example.TransfertNational.model.Transaction;
import com.example.TransfertNational.repository.TransactionRepository;
import com.example.TransfertNational.service.Implementation.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void getTransactions(){
        Transaction transaction1 = new Transaction();
        transaction1.setNumGSMBeneficiaire("0634214280");
        transaction1.setMontant(123.45);
        transaction1.setTypeTransfert("En Espèce");
        transaction1.setNotification(true);
        transaction1.setPrenomBeneficiaire("Saad");

        Transaction transaction2 = new Transaction();
        transaction2.setNumGSMBeneficiaire("0623642212");
        transaction2.setMontant(1553.45);
        transaction2.setTypeTransfert("En Espèce");
        transaction2.setNotification(true);
        transaction2.setPrenomBeneficiaire("Oussama");

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2);
        Mockito.when(transactionRepository.findAll()).thenReturn(transactions);

        List<TransactionDto> transactionDtoList = transactionService.getTransactions();

        assertEquals("0634214280", transactionDtoList.get(0).getNumGSMBeneficiaire());
        assertEquals("saad", transactionDtoList.get(0).getPrenomBeneficiaire());
        assertEquals("En Espèce", transactionDtoList.get(0).getTypeTransfert());
        assertEquals(true, transactionDtoList.get(0).isNotification());
        assertEquals(123.45, transactionDtoList.get(0).getMontant());

        assertEquals("0623642212", transactionDtoList.get(0).getNumGSMBeneficiaire());
        assertEquals("Oussama", transactionDtoList.get(0).getPrenomBeneficiaire());
        assertEquals("En Espèce", transactionDtoList.get(0).getTypeTransfert());
        assertEquals(true, transactionDtoList.get(0).isNotification());
        assertEquals(1553.45, transactionDtoList.get(0).getMontant());

    }
}
