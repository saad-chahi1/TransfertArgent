package com.example.TransfertNational.service.Implementation;

import com.example.TransfertNational.dto.CompteDto;
import com.example.TransfertNational.mapper.CompteMapper;
import com.example.TransfertNational.model.ComptePaiement;
import com.example.TransfertNational.repository.CompteRepository;
import com.example.TransfertNational.service.ICompteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService implements ICompteService{
    private final CompteRepository compteRepository ;

    public CompteService(CompteRepository compteRepository){
        this.compteRepository=compteRepository;
    }

    @Override
    public List<CompteDto> getComptes() {
        List<ComptePaiement> comptePaiements = compteRepository.findAll();
        return CompteMapper.mapToListDto(comptePaiements);
    }

    @Override
    public CompteDto getCompte(int id) {
        ComptePaiement comptePaiement = compteRepository.getById(id);
        return CompteMapper.mapToDto(comptePaiement);
    }

    @Override
    public CompteDto postCompte(CompteDto compteDto) throws Exception {
        ComptePaiement comptePaiement = new ComptePaiement();
        comptePaiement.setRip(compteDto.getRip());
        comptePaiement.setSolde(compteDto.getSolde());

        ComptePaiement compteAdded = compteRepository.save(comptePaiement);
        return CompteMapper.mapToDto(compteAdded);
    }
}
