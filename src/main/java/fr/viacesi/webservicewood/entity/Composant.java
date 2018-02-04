/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mgonzalez
 */
@Entity
@Table(name = "composant"
)
public class Composant {
    
    private int id;
    private String nom;
    private String gamme;
    private String dimensions;
    private String prix;
    private Set<ComposantInModule> composantInModules = new HashSet<ComposantInModule>(0);
     
    public Composant(){
        
    }
    
    public Composant(int id){
        this.id = id;
    }
    
    public Composant(String nom){
        this.nom = nom;
    }
    public Composant(int id, String nom, String gamme, String dimensions, String prix, Set<ComposantInModule> composantInModules){
        this.id = id;
        this.nom = nom;
        this.gamme = gamme;
        this.dimensions = dimensions;
        this.prix = prix;
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
     
    // GET AND SET NOM
    @Column(name="nom", length=50)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    // GET AND SET GAMME
    @Column(name="gamme", length=50)
    public String getGamme() {
        return this.gamme;
    }
    
    public void setGamme(String gamme) {
        this.gamme = gamme;
    } 
    
    // GET AND SET DIMENSIONS
    @Column(name="dimensions", length=50)
    public String getDimensions() {
        return this.dimensions;
    }
    
    public void setDimensions(String dimensions) {
       this.dimensions = dimensions;
    } 
    
    // GET AND SET PRIX
    @Column(name="prix", length=50)
    public String getPrix() {
        return this.prix;
    }
    
    public void setPrix(String prix) {
        this.prix = prix;
    } 
    
    // GET AND SET COMPOSANT IN MODULES
    @OneToMany( mappedBy = "composant" , cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ComposantInModule> getComposantInModules() {
        return this.composantInModules;
    }

    public void setComposantInModules(Set<ComposantInModule> composantInModules) {
        this.composantInModules = composantInModules;
    }
    

    
}
