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
public class DevisListDTO {
    private List<DevisDTO> devis;
    
    public DevisListDTO(){
        
    }
    /**
     * @return the devis
     */
    public List getDevis() {
        return devis;
    }

    /**
     * @param devis the devis to set
     */
    public void setDevis( List<DevisDTO> devis) {
        this.devis = devis;
    }
    
    
   
}
