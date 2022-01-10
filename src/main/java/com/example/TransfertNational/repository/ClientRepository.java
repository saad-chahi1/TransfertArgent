package com.example.TransfertNational.repository;

import com.example.TransfertNational.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("SELECT c FROM Client c WHERE c.Cin= ?1")
    Client findClientByCin(String Cin);
}
