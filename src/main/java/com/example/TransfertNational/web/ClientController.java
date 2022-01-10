package com.example.TransfertNational.web;

import com.example.TransfertNational.dto.ClientDto;
import com.example.TransfertNational.dto.TransactionDto;
import com.example.TransfertNational.service.Implementation.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDto> GetAll(){ return clientService.getClients(); }

    @GetMapping("/{id}")
    public ClientDto GetClientById(@PathVariable int id){
        return clientService.getClient(id);
    }

    @GetMapping("/{cin}")
    public ClientDto GetClientByCin(@RequestParam(value="cin") String cin){ return clientService.getClientByCin(cin); }

    @PostMapping
    public ClientDto Poster(@RequestBody ClientDto clientDto) throws Exception {
        return clientService.postClient(clientDto);
    }
}
