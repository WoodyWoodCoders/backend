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
    private ModuleDTO module;
    private ComposantDTO composant;
    private String disposition;
    
    public ComposantInModuleDTO(){
        
    }
    
    /**
     * @return the module
     */
    public ModuleDTO getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(ModuleDTO module) {
        this.module = module;
    }

    /**
     * @return the composant
     */
    public ComposantDTO getComposant() {
        return composant;
    }

    /**
     * @param composant the composant to set
     */
    public void setComposant(ComposantDTO composant) {
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
