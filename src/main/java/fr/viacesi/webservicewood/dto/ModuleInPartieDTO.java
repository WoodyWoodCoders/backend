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
public class ModuleInPartieDTO {
    private PartieDTO partie;
    private ModuleDTO module;
    private String disposition;
    
    public ModuleInPartieDTO(){
        
    }
    
    /**
     * @return the partie
     */
    public PartieDTO getPartie() {
        return partie;
    }

    /**
     * @param partie the partie to set
     */
    public void setPartie(PartieDTO partie) {
        this.partie = partie;
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
