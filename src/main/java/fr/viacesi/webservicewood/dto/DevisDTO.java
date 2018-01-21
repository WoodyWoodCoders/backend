/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Numalama
 */
public class DevisDTO {
    private Integer id;
    private Integer utilisateur;
    private Date dateCrea;
    private String nom;
    private String reference;
    private Integer status;
    private List client;
    //private Integer paiement;
    private List partis;
    
    public DevisDTO(){
        
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the utilisateur
      * */
    public Integer getUtilisateur() {
        return utilisateur;
    }
   
    /**
     * @param utilisateur the utilisateur to set
      * */
    public void setUtilisateur(Integer utilisateur) {
        this.utilisateur = utilisateur;
    }
  
    /**
     * @return the date_crea
     */
    public Date getDateCrea() {
        return dateCrea;
    }

    /**
     * @param date_crea the date_crea to set
     */
    public void setDateCrea(Date dateCrea) {
        this.dateCrea = dateCrea;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the client
     *  */
    public List getClient() {
        return client;
    }
   
    /**
     * @param client the client to set
     * */
    public void setClient(List client) {
        this.client = client;
    }
    
    /**
     * @return the paiementList
     
    public Integer getPaiement() {
        return paiement;
    }
    * /
    /**
     * @param paiementList the paiementList to set
    
    public void setPaiement(Integer paiement) {
        this.paiement = paiement;
    }
    * /
    /**
     * @return the partisList
     */
    public List getPartis() {
        return partis;
    }

    /**
     * @param partisList the partisList to set
     */
    public void setPartis(List partisList) {
        this.partis = partis;
    }

}
