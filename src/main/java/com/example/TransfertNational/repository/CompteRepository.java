package com.example.TransfertNational.repository;
;
import com.example.TransfertNational.model.ComptePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<ComptePaiement, Integer> {
}
