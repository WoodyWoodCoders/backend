/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mgonzalez
 */
@Entity
@Table(name = "paiement"
)
public class Paiement implements java.io.Serializable {
    
    private int id;
    private int montant;
    private Date date_paiement;
    private int moyen;
    private Devis devis;
    private Client client;
    
    public Paiement(){
        
    }
    
    public Paiement(int id){
        this.id = id;
    }
    
    public Paiement(int id, int montant, Date date_paiement, int moyen, Devis devis, Client client){
        this.id = id;
        this.montant = montant;
        this.date_paiement = date_paiement;
        this.moyen = moyen;
        this.devis = devis;
        this.client = client;
    }
    
    // GET AND SET ID
    @Id
    @GenericGenerator(name = "kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }
    
     public void setId(int id) {
        this.id = id;
    }
    
    // GET AND SET MONTANT
    @Column(name="montant")
    public Integer getMontant() {
        return this.montant;
    }
    
    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    // GET AND SET DATE DATE PAIEMENT
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_paiement")
    public Date getDatePaiement(){
        return this.date_paiement;
    }
    
    public void setDatePaiement(Date date_paiement){
        this.date_paiement = date_paiement;
    }
    
    // GET AND SET MOYEN
    @Column(name="moyen")
    public Integer getMoyen() {
        return this.moyen;
    }
    
    public void setMoyen(int moyen) {
        this.moyen = moyen;
    }
    
    // GET AND SET DEVIS
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="devis_id")
    public Devis getDevis() {
        return this.devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    
    // GET AND SET CLIENT
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id")
    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

