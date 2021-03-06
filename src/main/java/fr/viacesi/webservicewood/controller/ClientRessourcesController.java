/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import fr.viacesi.webservicewood.dto.ClientDTO;
import fr.viacesi.webservicewood.dto.ClientListDTO;
import fr.viacesi.webservicewood.entity.Client;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.service.ClientService;
import fr.viacesi.webservicewood.service.DevisService;
import fr.viacesi.webservicewood.service.UtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Client> getClients() {  
        return clientService.getClients();
    }
    
    @RequestMapping(value = "/get/all/dto", method = RequestMethod.GET)
    public List<ClientDTO> getClientsDTO() {  
        return clientService.getClientsDTO();
    }
    
    // get 1 client
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ClientDTO getClient(@PathVariable("id") int id) {  
        System.out.println("id : " + id);
        return clientService.getClient(id);
    }
    
    // edit client
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ClientDTO updateClient(@RequestBody Client client) {  
        return clientService.updateClient(client);
    }
    
    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> deleteClient(@PathVariable("id") int id) {  
      boolean response = clientService.deleteClient(id);
      return this.responseSuccess(response);
    }
   
 
}
