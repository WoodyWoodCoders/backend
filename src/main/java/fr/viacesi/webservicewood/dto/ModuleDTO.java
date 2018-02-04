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
public class ModuleDTO {
    private Integer id;
    private Date date_crea;
    private String nom;
    private String dimension;
    private String prix;
    private ModuleInPartieDTO moduleInParties;
    private ComposantInModuleDTO composantInModules;
    
    public ModuleDTO(){
        
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
     * @return the dimension
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    /**
     * @return the prix
     */
    public String getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(String prix) {
        this.prix = prix;
    }

    /**
     * @return the moduleInParties
     */
    public ModuleInPartieDTO getModuleInParties() {
        return moduleInParties;
    }

    /**
     * @param moduleInParties the moduleInParties to set
     */
    public void setModuleInParties(ModuleInPartieDTO moduleInParties) {
        this.moduleInParties = moduleInParties;
    }

    /**
     * @return the composantInModules
     */
    public ComposantInModuleDTO getComposantInModules() {
        return composantInModules;
    }

    /**
     * @param composantInModules the composantInModules to set
     */
    public void setComposantInModules(ComposantInModuleDTO composantInModules) {
        this.composantInModules = composantInModules;
    }

}
