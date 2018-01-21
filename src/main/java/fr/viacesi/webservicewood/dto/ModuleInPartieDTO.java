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
    private Integer partie;
    private Integer module;
    private String disposition;
    
    public ModuleInPartieDTO(){
        
    }
    
    /**
     * @return the partie
     */
    public Integer getPartie() {
        return partie;
    }

    /**
     * @param partie the partie to set
     */
    public void setPartie(Integer partie) {
        this.partie = partie;
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
