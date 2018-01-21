/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import fr.viacesi.webservicewood.dto.ClientDTO;
import fr.viacesi.webservicewood.dto.ClientListDTO;
import fr.viacesi.webservicewood.entity.Client;
import fr.viacesi.webservicewood.service.ClientService;
import fr.viacesi.webservicewood.service.DevisService;
import fr.viacesi.webservicewood.service.UtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Numalama
 */
@RestController
@RequestMapping("/rest/client")
public class ClientRessourcesController extends AbstractSecureController{
    @Autowired
    private DevisService devisService;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private ClientService clientService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ClientDTO createClient(@RequestBody Client client) {
        return clientService.creatClient(client);
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Client> getClients() {  
        return clientService.getClients();
    }
    
}
