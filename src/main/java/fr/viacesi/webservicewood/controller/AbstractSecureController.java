/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;


import fr.viacesi.webservicewood.dto.DevisListDTO;
import fr.viacesi.webservicewood.dto.UtilisateurDTO;
import fr.viacesi.webservicewood.entity.Utilisateur;
import fr.viacesi.webservicewood.service.UtilisateurService;
import io.jsonwebtoken.Claims;
import javax.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Manuel Gonzalez
 */
public abstract class AbstractSecureController extends AbstractController {
    
    protected UtilisateurDTO utilisateur;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    /**
     * Retrieve the authenticated user. (cache)
     * The user is retrieved from db only first time and is cached.
     * @return User
     */
    public UtilisateurDTO getUtilisateur(){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Claims claims = (Claims) request.getAttribute("claims");
            int userId = claims.get("utilisateur", Integer.class);
            System.out.println("userId" + userId);
            //this.utilisateur = utilisateurService.findById(userId);
            //GET USER IN DB
            Utilisateur userDao = utilisateurService.findById(userId);
            // NEW MAPPER
            ModelMapper modelMapper = new ModelMapper();
            // MAP LIST OF USER DEVIS DAO TO LIST OF USER DTO
            UtilisateurDTO utilisateurDTO = modelMapper.map(userDao, UtilisateurDTO.class);
            this.utilisateur = utilisateurDTO;
            return this.utilisateur;
    }
 
    /**
     * Retrieve the authenticated user. (no cache)
     * The user is retrieved from db and not from cache.
     * @return User
     */
    /*
    public UtilisateurDTO getUtilisateur(boolean refresh){
        if(this.utilisateur == null || refresh){
           
        }
        
        return this.utilisateur;
    }
    */
    
}
