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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "module"
)
public class Module {
    private int id;
    private Date date_crea;
    private String nom;
    private String dimension;
    private String prix;
    private Set<ModuleInPartie> moduleInParties = new HashSet<ModuleInPartie>(0);
    private Set<ComposantInModule> composantInModules = new HashSet<ComposantInModule>(0);
     
    public Module(){
        
    }
    
    public Module(int id){
        this.id = id;
    }
    
    public Module(String nom){
        this.nom = nom;
    }
    
    public Module(int id, Date date_crea, String nom, String dimension, String prix, Set<ModuleInPartie> moduleInParties, Set<ComposantInModule> composantInModules){
        this.id = id;
        this.date_crea = date_crea;
        this.nom = nom;
        this.dimension = dimension;
        this.prix = prix;
        this.moduleInParties = moduleInParties;
        this.composantInModules = composantInModules;
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
    
    // GET AND SET DATE_CREA
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_crea")
    public Date getDateCrea(){
        return this.date_crea;
    }
    
    public void setDateCrea(Date date_crea){
        this.date_crea = date_crea;
    }
    
    // GET AND SET NOM
    @Column(name="nom", length=50)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    // GET AND SET DIMENSION
    @Column(name="dimension", length=50)
    public String getDimension() {
        return this.dimension;
    }
    
    public void setDimension(String dimension) {
        this.dimension = dimension;
    } 
    
    // GET AND SET PRIX
    @Column(name="prix", length=50)
    public String getPrix() {
        return this.prix;
    }
    
    public void setPrix(String prix) {
        this.prix = prix;
    } 
    
    // GET AND SET MODULES IN PARTIES
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ModuleInPartie> getModuleInParties() {
        return this.moduleInParties;
    }

    public void setModuleInParties(Set<ModuleInPartie> moduleInParties) {
        this.moduleInParties = moduleInParties;
    }
    
    // GET AND SET COMPOSANTS IN MODULES
    @OneToMany( mappedBy = "module" , cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ComposantInModule> getComposantInModules() {
        return this.composantInModules;
    }

    public void setComposantInModules(Set<ComposantInModule> composantInModules ) {
        this.composantInModules = composantInModules;
    }
}
