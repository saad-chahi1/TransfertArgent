package com.example.TransfertNational.repository;

import com.example.TransfertNational.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value="select c from client c where c.cin= ?1", nativeQuery=true)
    Client findClientByCin(String cin);

    @Query(value = "select c from client c where c.gsm= ?1", nativeQuery=true)
    Client findClientByGsm(String gsm);
}
