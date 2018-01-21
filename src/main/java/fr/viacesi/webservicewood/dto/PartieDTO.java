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
public class PartieDTO {
    
    private Integer id;
    private String nom;
    private Date date_crea;
    private String disposition;
    private Integer devis;
    private List moduleInPartiesList ;
    
    public PartieDTO(){
        
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
     * @return the date_crea
     */
    public Date getDate_crea() {
        return date_crea;
    }

    /**
     * @param date_crea the date_crea to set
     */
    public void setDate_crea(Date date_crea) {
        this.date_crea = date_crea;
    }

    /**
     * @return the disposition
     */
    public String getDisposition() {
        return disposition;
    }

    /**
     * @param disposition the disposition to set
     */
    public void setDisposition(String disposition) {
        this.disposition = disposition;
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
     * @return the moduleInPartiesList
     */
    public List getModuleInPartiesList() {
        return moduleInPartiesList;
    }

    /**
     * @param moduleInPartiesList the moduleInPartiesList to set
     */
    public void setModuleInPartiesList(List moduleInPartiesList) {
        this.moduleInPartiesList = moduleInPartiesList;
    }

}
