/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import fr.viacesi.webservicewood.dto.ComposantDTO;
import fr.viacesi.webservicewood.entity.Composant;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.service.ComposantService;
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
@RequestMapping("/rest/composant")
public class ComposantRessourcesController extends AbstractSecureController{
    @Autowired
    private ComposantService composantService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ComposantDTO createComposant(@RequestBody Composant composant) {
         return composantService.creatComposant(composant);
    }
    
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Composant> getComposants() {  
        return composantService.getComposants();
    }
    
    @RequestMapping(value = "/get/all/dto", method = RequestMethod.GET)
    public List<ComposantDTO> getComposantsDTO() {  
        return composantService.getComposantsDTO();
    }
    
    // get 1 client
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ComposantDTO getComposant(@PathVariable("id") int id) {  
        System.out.println("id : " + id);
        return composantService.getComposant(id);
    }
    
    // edit client
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ComposantDTO updateComposant(@RequestBody Composant composant) {  
        return composantService.updateComposant(composant);
    }
    
    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> deleteComposant(@PathVariable("id") int id) {  
      boolean response = composantService.deleteComposant(id);
      return this.responseSuccess(response);
    }
   
 
}
