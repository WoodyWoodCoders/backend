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
public class ClientListDTO {
     private List client;
     
     public ClientListDTO(){
         
     }
    /**
     * @return the clientList
     */
    public List getClient() {
        return client;
    }

    /**
     * @param clientList the clientList to set
     */
    public void setClien(List client) {
        this.client = client;
    }
   
}
