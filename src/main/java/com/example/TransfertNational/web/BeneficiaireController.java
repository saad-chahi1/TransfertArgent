package com.example.TransfertNational.web;

import com.example.TransfertNational.dto.BeneficiaireDto;
import com.example.TransfertNational.service.Implementation.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/beneficiaires")
@CrossOrigin(origins = "http://localhost:4200")
public class BeneficiaireController {
    @Autowired
    BeneficiaireService beneficiaireService;

    @GetMapping
    public List<BeneficiaireDto> GetAll(){
        return beneficiaireService.getBeneficiaires();
    }

    @GetMapping("/{id}")
    public BeneficiaireDto GetBeneficiaireById(@PathVariable int id){
        return beneficiaireService.getBeneficiaire(id);
    }

    @PostMapping
    public BeneficiaireDto PostBeneficiaire(@RequestBody BeneficiaireDto beneficiaireDto)throws Exception{
        return beneficiaireService.postBeneficiaire(beneficiaireDto);
    }
}
