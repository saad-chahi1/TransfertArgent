package com.example.TransfertNational.web;

import com.example.TransfertNational.dto.TransactionDto;
import com.example.TransfertNational.service.Implementation.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<TransactionDto> GetAll(){ return transactionService.getTransactions(); }

    @GetMapping("/{id}")
    public TransactionDto GetTransaction(@PathVariable int id){
        return transactionService.getTransaction(id);
    }

    @PostMapping
    public TransactionDto Poster(@RequestBody TransactionDto transactionDto) throws Exception {
        return transactionService.postTransaction(transactionDto);
    }
}
