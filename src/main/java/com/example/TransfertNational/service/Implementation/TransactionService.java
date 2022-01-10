package com.example.TransfertNational.service.Implementation;

import com.example.TransfertNational.dto.TransactionDto;
import com.example.TransfertNational.exceptions.SoldeInsuffisantException;
import com.example.TransfertNational.mapper.TransactionMapper;
import com.example.TransfertNational.model.Client;
import com.example.TransfertNational.model.Transaction;
import com.example.TransfertNational.repository.ClientRepository;
import com.example.TransfertNational.repository.TransactionRepository;
import com.example.TransfertNational.service.ITransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    private final TransactionRepository transactionRepository;

    private final ClientRepository clientRepository;

    public TransactionService(TransactionRepository transactionRepository, ClientRepository clientRepository){
        this.transactionRepository=transactionRepository;
        this.clientRepository = clientRepository;
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
    public TransactionDto postTransaction(TransactionDto transactionDto) throws Exception, SoldeInsuffisantException {
        ChangerSolde(transactionDto);

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

    public void ChangerSolde(TransactionDto transactionDto){
        Client client = clientRepository.findClientByGsm(transactionDto.getNumTele());
        Double soldeAct = Double.parseDouble(client.getSolde());
        Double montant = transactionDto.getMontant();
        if((soldeAct - montant)>=0){
            client.setSolde(Double.toString(soldeAct - montant));
        }else{
            throw new SoldeInsuffisantException("Votre solde est insuffisant");
        }
    }
}
