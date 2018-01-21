/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import fr.viacesi.webservicewood.dto.DevisDTO;
import fr.viacesi.webservicewood.dto.DevisListDTO;
import fr.viacesi.webservicewood.entity.Devis;
import fr.viacesi.webservicewood.entity.Utilisateur;
import fr.viacesi.webservicewood.service.DevisService;
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
@RequestMapping("/rest/devis")
public class DevisRessourcesController extends AbstractSecureController {

    @Autowired
    private DevisService devisService;
    

    // CREATE A NEW DEVIS AND AFFECT THE CURRENT_USER TO THIS DEVIS;
    // RETURN THE DEVIS MAPPED TO DTO
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DevisDTO creatDevis(@RequestBody Devis devis) {
        Utilisateur current_utilisateur = this.getUtilisateur();
        return devisService.creatDevis(current_utilisateur, devis);
    }
    
    // RETURN LIST OF THE USER'S DEVIS MAPPED TO DTO
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public DevisListDTO getUserDevis() {
        Utilisateur utilisateur = this.getUtilisateur();   
        return devisService.getUserDevis(utilisateur);
    }
    
    // RETURN LIST OF ALL DEVIS IN DATABASE
    @RequestMapping(value = "/get/all/dao", method = RequestMethod.GET)
    public List<Devis> getAllDevisDao() {
        return devisService.getAllDevisDAO();
    }
    
    // RETURN LIST OF ALL DEVIS MAPPED TO DTO
    @RequestMapping(value = "/get/all/dto", method = RequestMethod.GET)
    public List<DevisDTO> getAllDevisDto() {
        return devisService.getAllDevisDTO();
    }
    
   

}
