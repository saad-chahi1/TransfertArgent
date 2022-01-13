package com.example.TransfertNational.web;

import com.example.TransfertNational.dto.ClientDto;
import com.example.TransfertNational.service.Implementation.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDto> GetAll(){ return clientService.getClients(); }

    @GetMapping("/{id}")
    public ClientDto GetClientById(@PathVariable int id){
        return clientService.getClient(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{cin}")
    public ClientDto GetClientByCin(@RequestParam(value="cin") String cin){ return clientService.getClientByCin(cin); }

    //Pour débit de compte
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{gsm}")
    public ClientDto GetClientByGsm(@RequestParam(value="gsm") String gsm){ return clientService.getClientByGsm(gsm); }

    @PostMapping
    public ClientDto Poster(@RequestBody ClientDto clientDto) throws Exception {
        return clientService.postClient(clientDto);
    }
}
