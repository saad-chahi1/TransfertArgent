package com.example.TransfertNational.service.Implementation;

import com.example.TransfertNational.dto.BeneficiaireDto;
import com.example.TransfertNational.mapper.BeneficiaireMapper;
import com.example.TransfertNational.model.Beneficiaire;
import com.example.TransfertNational.repository.BeneficiaireRepository;
import com.example.TransfertNational.service.IBeneficiaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaireService implements IBeneficiaireService {
    private final BeneficiaireRepository beneficiaireRepository;

    public BeneficiaireService(BeneficiaireRepository beneficiaireRepository){
        this.beneficiaireRepository = beneficiaireRepository;
    }

    @Override
    public List<BeneficiaireDto> getBeneficiaires() {
        List<Beneficiaire> beneficiaires = beneficiaireRepository.findAll();
        return BeneficiaireMapper.mapToListDto(beneficiaires);
    }

    @Override
    public BeneficiaireDto getBeneficiaire(int id) {
        Beneficiaire beneficiaire = beneficiaireRepository.getById(id);
        return BeneficiaireMapper.mapToDto(beneficiaire);
    }

    @Override
    public BeneficiaireDto postBeneficiaire(BeneficiaireDto beneficiaireDto) throws Exception {
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setGsm(beneficiaireDto.getGsm());
        beneficiaire.setPrenom(beneficiaireDto.getPrenom());
        beneficiaire.setNom(beneficiaireDto.getNom());

        Beneficiaire beneAdded = beneficiaireRepository.save(beneficiaire);
        return BeneficiaireMapper.mapToDto(beneAdded);
    }


}
