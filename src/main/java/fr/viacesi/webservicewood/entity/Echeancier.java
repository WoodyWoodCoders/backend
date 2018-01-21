/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author 1797531
 */
@Entity
@Table(name = "Echeancier"
)
public class Echeancier implements java.io.Serializable{
    private int id;
    private Devis devis;
    private int nbMois;
    private int jourDuMois;
    private int nbPaiements;
    private float montantPaiement;
    
    public Echeancier(){
        
    }
    
    public Echeancier(int id){
        this.id = id;
    }
    
    public Echeancier(int id, Devis devis, int nbMois, int jourDuMois, int nbPaiements, float montantPaiement ){
        this.id = id;
        this.devis = devis;
        this.nbMois = nbMois;
        this.jourDuMois = jourDuMois;
        this.nbPaiements = nbPaiements;
        this.montantPaiement = montantPaiement;
    }
    
    
    /**
     * @return the id
     */
    // GET AND SET ID
    @Id
    @GenericGenerator(name = "kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    // GET AND SET DEVIS
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "devis_id", nullable = false)
    public Devis getDevis() {
        return this.devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    
    /**
     * @return the nbMois
     */
    // GET AND SET NbMois
    @Column(name="nbMois", length=50)
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
    @Column(name="jourDuMois", length=50)
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
    @Column(name="nbPaiements")
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
    @Column(name="montantPaiement")
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
