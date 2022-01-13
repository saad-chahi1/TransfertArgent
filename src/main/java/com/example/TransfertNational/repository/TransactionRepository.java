package com.example.TransfertNational.repository;

import com.example.TransfertNational.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "select t from transaction t where t.otp= ?1", nativeQuery=true)
    Transaction findTransactionByOtp(String otp);
}
