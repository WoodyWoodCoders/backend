/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import fr.viacesi.webservicewood.dto.ClientDTO;
import fr.viacesi.webservicewood.dto.ComposantDTO;
import fr.viacesi.webservicewood.dto.PaiementDTO;
import fr.viacesi.webservicewood.entity.Client;
import fr.viacesi.webservicewood.entity.Composant;
import fr.viacesi.webservicewood.entity.Paiement;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.service.ClientService;
import fr.viacesi.webservicewood.service.ComposantService;
import fr.viacesi.webservicewood.service.DevisService;
import fr.viacesi.webservicewood.service.PaiementService;
import fr.viacesi.webservicewood.service.UtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 1797531
 */
@RestController
@RequestMapping("/rest/paiement")
public class PaiementRessourcesController extends AbstractSecureController{
    @Autowired
    private PaiementService paiementService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public PaiementDTO createPaiement(@RequestBody Paiement paiement) {
        return paiementService.creatPaiement(paiement);
    }
    
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Paiement> getComposants() {  
        return paiementService.getPaiements();
    }
    
    @RequestMapping(value = "/get/all/dto", method = RequestMethod.GET)
    public List<PaiementDTO> getPaiementsDTO() {  
        return paiementService.getPaiementsDTO();
    }
    
    // get 1 client
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public PaiementDTO getPaiement(@PathVariable("id") int id) {  
        System.out.println("id : " + id);
        return paiementService.getPaiement(id);
    }
    
    // edit client
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public PaiementDTO updatePaiement(@RequestBody Paiement paiement) {  
        return paiementService.updatePaiement(paiement);
    }
    
    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> deletePaiement(@PathVariable("id") int id) {  
      boolean response = paiementService.deletePaiement(id);
      return this.responseSuccess(response);
    }
   
 
}
