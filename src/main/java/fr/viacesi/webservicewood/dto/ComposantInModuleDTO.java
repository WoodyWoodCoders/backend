/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dto;

/**
 *
 * @author Numalama
 */
public class ComposantInModuleDTO {
    private Integer module;
    private Integer composant;
    private String disposition;
    
    public ComposantInModuleDTO(){
        
    }
    
    /**
     * @return the module
     */
    public Integer getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(Integer module) {
        this.module = module;
    }

    /**
     * @return the composant
     */
    public Integer getComposant() {
        return composant;
    }

    /**
     * @param composant the composant to set
     */
    public void setComposant(Integer composant) {
        this.composant = composant;
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

}
