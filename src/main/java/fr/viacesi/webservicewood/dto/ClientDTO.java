/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dto;

import java.util.Date;

/**
 *
 * @author Numalama
 */
public class ClientDTO {
    private Integer id;
    private Integer devis;
    private Integer paiement;
    private String nom;
    private Integer telephone;
    private String adresse;
    private Integer cp;
    private String ville;
    private Date dateCrea;
    
    public ClientDTO(){
        
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
     * @return the devis
     */
    public Integer getDevis() {
        return devis;
    }

    /**
     * @param devis the devis to set
     */
    public void setDevis(Integer devis) {
        this.devis = devis;
    }

    /**
     * @return the paiement
     */
    public Integer getPaiement() {
        return paiement;
    }

    /**
     * @param paiement the paiement to set
     */
    public void setPaiement(Integer paiement) {
        this.paiement = paiement;
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
     * @return the telephone
     */
    public Integer getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the cp
     */
    public Integer getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(Integer cp) {
        this.cp = cp;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
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

}
