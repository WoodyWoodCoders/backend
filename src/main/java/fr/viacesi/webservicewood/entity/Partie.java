/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mgonzalez
 */
@Entity
@Table(name = "partie"
)
public class Partie implements java.io.Serializable{
    
    private int id;
    private String nom;
    private Date date_crea;
    private String disposition;
    private Devis devis;
    private Set<ModuleInPartie> moduleInParties = new HashSet<ModuleInPartie>(0);
    //private Set<Module> modules = new HashSet<Module>(0);
    
    public Partie(){
        
    }
    
    public Partie(int id){
        this.id = id;
    }
    
    public Partie(int id, String nom, Date date_crea, String disposition, Devis devis, Set<ModuleInPartie> moduleInParties ){
        this.id = id;
        this.nom = nom;
        this.date_crea = date_crea;
        this.disposition = disposition;
        this.devis = devis;
        this.moduleInParties = moduleInParties;
        
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
     
    // GET AND SET NOM
    @Column(name="nom", length=50)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    // GET AND SET DATE_CREA
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_crea")
    public Date getDateCrea(){
        return this.date_crea;
    }
    
    public void setDateCrea(Date date_crea){
        this.date_crea = date_crea;
    }
    
    // GET AND SET DISPOSITION
    @Column(name="disposition", length=50)
    public String getDisposition() {
        return this.disposition;
    }
    
    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }   
    
    // GET AND SET DEVIS
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="devis_id", nullable=false)
    public Devis getDevis() {
        return this.devis;
    }
    
    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    
    // GET AND SET MODULES IN PARTIES
    @OneToMany( mappedBy = "partie", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ModuleInPartie> getModuleInParties() {
        return this.moduleInParties;
    }

    public void setModuleInParties(Set<ModuleInPartie> moduleInParties) {
        this.moduleInParties = moduleInParties;
    }
    
}
