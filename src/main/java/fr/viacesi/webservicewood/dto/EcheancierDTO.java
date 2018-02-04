/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dto;

import fr.viacesi.webservicewood.entity.Devis;

/**
 *
 * @author 1797531
 */
public class EcheancierDTO {
    
    private int id;
    private DevisDTO devis;
    private int nbMois;
    private int jourDuMois;
    private int nbPaiements;
    private float montantPaiement;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the nbMois
     */
    public int getNbMois() {
        return nbMois;
    }

    /**
     * @param nbMois the nbMois to set
     */
    public void setNbMois(int nbMois) {
        this.nbMois = nbMois;
    }

    /**
     * @return the jourDuMois
     */
    public int getJourDuMois() {
        return jourDuMois;
    }

    /**
     * @param jourDuMois the jourDuMois to set
     */
    public void setJourDuMois(int jourDuMois) {
        this.jourDuMois = jourDuMois;
    }

    /**
     * @return the nbPaiements
     */
    public int getNbPaiements() {
        return nbPaiements;
    }

    /**
     * @param nbPaiements the nbPaiements to set
     */
    public void setNbPaiements(int nbPaiements) {
        this.nbPaiements = nbPaiements;
    }

    /**
     * @return the montantPaiement
     */
    public float getMontantPaiement() {
        return montantPaiement;
    }

    /**
     * @param montantPaiement the montantPaiement to set
     */
    public void setMontantPaiement(float montantPaiement) {
        this.montantPaiement = montantPaiement;
    }
    
}
