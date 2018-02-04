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
public class PaiementDTO {
    
    private Integer id;
    private Integer montant;
    private Date date_paiement;
    private Integer moyen;
    private DevisDTO devis;
    private ClientDTO client;
    
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
     * @return the montant
     */
    public Integer getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    /**
     * @return the date_paiement
     */
    public Date getDate_paiement() {
        return date_paiement;
    }

    /**
     * @param date_paiement the date_paiement to set
     */
    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }

    /**
     * @return the moyen
     */
    public Integer getMoyen() {
        return moyen;
    }

    /**
     * @param moyen the moyen to set
     */
    public void setMoyen(Integer moyen) {
        this.moyen = moyen;
    }

    /**
     * @return the devis
     */
    public DevisDTO getDevis() {
        return devis;
    }

    /**
     * @param devis the devis to set
     */
    public void setDevis(DevisDTO devis) {
        this.devis = devis;
    }

    /**
     * @return the client
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

}
