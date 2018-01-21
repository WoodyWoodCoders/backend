/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;


import fr.viacesi.webservicewood.entity.Utilisateur;
import fr.viacesi.webservicewood.service.UtilisateurService;
import io.jsonwebtoken.Claims;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Manuel Gonzalez
 */
public abstract class AbstractSecureController extends AbstractController {
    
    protected Utilisateur utilisateur;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    /**
     * Retrieve the authenticated user. (cache)
     * The user is retrieved from db only first time and is cached.
     * @return User
     */
    public Utilisateur getUtilisateur(){
        return this.getUtilisateur(false);
    }
 
    /**
     * Retrieve the authenticated user. (no cache)
     * The user is retrieved from db and not from cache.
     * @return User
     */
    public Utilisateur getUtilisateur(boolean refresh){
        if(this.utilisateur == null || refresh){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Claims claims = (Claims) request.getAttribute("claims");
            int userId = claims.get("utilisateur", Integer.class);
            this.utilisateur = utilisateurService.findById(userId);
        }
        
        return this.utilisateur;
    }
    
    
}
