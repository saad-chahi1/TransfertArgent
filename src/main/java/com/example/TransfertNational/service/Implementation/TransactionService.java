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

import java.util.Date;
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
    public TransactionDto getTransactionByOtp(String otp) {
        Transaction transaction = transactionRepository.findTransactionByOtp(otp);
        return  TransactionMapper.mapToDto(transaction);
    }

    @Override
    public TransactionDto postTransaction(TransactionDto transactionDto) throws Exception, SoldeInsuffisantException {
        if(transactionDto.getTypeTransfert()=="Débit de compte du client"){
            EditClientSolde(transactionDto);
        }else if(transactionDto.getTypeTransfert()=="En espèce"){
            EditAgentSolde(transactionDto);
        }

        Transaction transaction = new Transaction();
        transaction.setTypeTransfert(transactionDto.getTypeTransfert());
        transaction.setNotification(transactionDto.isNotification());
        transaction.setFraitTransfert(transactionDto.getFraitTransfert());
        transaction.setNumTele(transactionDto.getNumTele());
        transaction.setMontant(transactionDto.getMontant());
        transaction.setNomBeneficiaire(transactionDto.getNomBeneficiaire());
        transaction.setPrenomBeneficiaire(transactionDto.getPrenomBeneficiaire());
        transaction.setNumGSMBeneficiaire(transactionDto.getNumGSMBeneficiaire());
        transaction.setOtp(transactionDto.getOtp());
        transaction.setDate(transactionDto.getDate());

        Transaction addedTr = transactionRepository.save(transaction);
        return TransactionMapper.mapToDto(addedTr);
    }

    public void EditClientSolde(TransactionDto transactionDto){
        Client client = clientRepository.findClientByGsm(transactionDto.getNumTele());
        String soldeClient = client.getComptePaiement().getSolde();
        Double soldeAct = Double.parseDouble(soldeClient);
        Double montant = transactionDto.getMontant();
        Double fraitTransfert = transactionDto.getFraitTransfert();
        if((soldeAct - montant - fraitTransfert)>=0){
            client.getComptePaiement().setSolde(Double.toString(soldeAct - montant - fraitTransfert));
        }else{
            throw new SoldeInsuffisantException("Votre solde est insuffisant");
        }
    }
    //For espece
    public void EditAgentSolde(TransactionDto transactionDto){
        Client client = clientRepository.findClientByCin(transactionDto.getCin());
        Double soldeAct = Double.parseDouble(transactionDto.getAgent().getMontant());
        Double montant = transactionDto.getMontant();
        if((soldeAct - montant)>=0){
            transactionDto.getAgent().setMontant(Double.toString(soldeAct - montant));
        }else{
            throw new SoldeInsuffisantException("le solde de l'agence est insuffisant");
        }
    }
}
