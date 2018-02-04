/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import fr.viacesi.webservicewood.dto.ClientDTO;
import fr.viacesi.webservicewood.dto.ComposantDTO;
import fr.viacesi.webservicewood.dto.EcheancierDTO;
import fr.viacesi.webservicewood.dto.PaiementDTO;
import fr.viacesi.webservicewood.entity.Client;
import fr.viacesi.webservicewood.entity.Composant;
import fr.viacesi.webservicewood.entity.Echeancier;
import fr.viacesi.webservicewood.entity.Paiement;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.service.ClientService;
import fr.viacesi.webservicewood.service.ComposantService;
import fr.viacesi.webservicewood.service.DevisService;
import fr.viacesi.webservicewood.service.EcheancierService;
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
@RequestMapping("/rest/echeancier")
public class EcheancierRessourcesController extends AbstractSecureController{
    @Autowired
    private EcheancierService echeancierService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public EcheancierDTO createEcheancier(@RequestBody Echeancier echeancier) {
        return echeancierService.creatEcheancier(echeancier);
    }
    
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Echeancier> getEcheanciers() {  
        return echeancierService.getEcheanciers();
    }
    
    @RequestMapping(value = "/get/all/dto", method = RequestMethod.GET)
    public List<EcheancierDTO> getEcheanciersDTO() {  
        return echeancierService.getEcheanciersDTO();
    }
    
    // get 1 client
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public EcheancierDTO getEcheancier(@PathVariable("id") int id) {  
        System.out.println("id : " + id);
        return echeancierService.getEcheancier(id);
    }
    
    // edit client
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public EcheancierDTO updateEcheancier(@RequestBody Echeancier echeancier) {  
        return echeancierService.updateEcheancier(echeancier);
    }
    
    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> deleteEcheancier(@PathVariable("id") int id) {  
      boolean response = echeancierService.deleteEcheancier(id);
      return this.responseSuccess(response);
    }
   
 
}
