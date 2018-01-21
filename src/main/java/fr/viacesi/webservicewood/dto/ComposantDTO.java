/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dto;

import java.util.List;

/**
 *
 * @author Numalama
 */
public class ComposantDTO {
    private Integer id;
    private String nom;
    private String gamme;
    private String dimensions;
    private String prix;
    private List composantInModules;
    
    public ComposantDTO(){
        
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
     * @return the gamme
     */
    public String getGamme() {
        return gamme;
    }

    /**
     * @param gamme the gamme to set
     */
    public void setGamme(String gamme) {
        this.gamme = gamme;
    }

    /**
     * @return the dimensions
     */
    public String getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
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
     * @return the composantInModules
     */
    public List getComposantInModules() {
        return composantInModules;
    }

    /**
     * @param composantInModules the composantInModules to set
     */
    public void setComposantInModules(List composantInModules) {
        this.composantInModules = composantInModules;
    }

}
