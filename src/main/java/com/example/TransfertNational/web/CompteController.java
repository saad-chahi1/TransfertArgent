package com.example.TransfertNational.web;

import com.example.TransfertNational.dto.CompteDto;
import com.example.TransfertNational.service.Implementation.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<CompteDto>  GetAll() {
        return compteService.getComptes();
    }
    @GetMapping("/{id}")
    public CompteDto GetCompte(@PathVariable int id){
        return compteService.getCompte(id);
    }
    @PostMapping
    public CompteDto PostCompte(@RequestBody CompteDto compteDto) throws Exception {
        return compteService.postCompte(compteDto);
    }
}
