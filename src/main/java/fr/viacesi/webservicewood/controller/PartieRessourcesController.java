/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import fr.viacesi.webservicewood.dto.ModuleDTO;
import fr.viacesi.webservicewood.dto.PartieDTO;
import fr.viacesi.webservicewood.entity.ModuleInPartie;
import fr.viacesi.webservicewood.entity.Partie;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.service.PartieService;
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
@RequestMapping("/rest/partie")
public class PartieRessourcesController extends AbstractSecureController{
    @Autowired
    private PartieService partieService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public PartieDTO createPartie(@RequestBody Partie partie) {
        return partieService.creatPartie(partie);
    }
    
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Partie> getParties() {  
        return partieService.getParties();
    }
    
    @RequestMapping(value = "/get/all/dto", method = RequestMethod.GET)
    public List<PartieDTO> getPartiesDTO() {  
        return partieService.getPartiesDTO();
    }
    
    // get 1 client
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public PartieDTO getPartie(@PathVariable("id") int id) {  
        System.out.println("id : " + id);
        return partieService.getPartie(id);
    }
        // get 1 client
    @RequestMapping(value = "/get/all/modules/{id}", method = RequestMethod.GET)
    public List<ModuleDTO> getModuleInPartie(@PathVariable("id") int id) {  
        System.out.println("id : " + id);
         return partieService.getModuleInpartieDTO(id);
    }
    
    // get 1 client
    @RequestMapping(value = "/set/module/", method = RequestMethod.POST)
    public List<ModuleDTO> SetModuleInPartie(@RequestBody ModuleInPartie moduleInPartie) {  
        return partieService.setModuleInpartieDTO(moduleInPartie.getPartie().getId(), moduleInPartie.getModule().getId(), moduleInPartie.getDisposition() );
    }
    // edit client
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public PartieDTO updatePaiement(@RequestBody Partie partie) {  
        return partieService.updatePartie(partie);
    }
    
    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> deletePaiement(@PathVariable("id") int id) {  
      boolean response = partieService.deletePartie(id);
      return this.responseSuccess(response);
    }
   
 
}
