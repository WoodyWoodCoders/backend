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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "client",catalog = "wood_app"
)
public class Client implements java.io.Serializable{
    
    private int id;
    private Set<Devis> devis = new HashSet<Devis>(0);
    private Paiement paiement;
    private String nom;
    private int telephone;
    private String adresse;
    private int cp;
    private String ville;
    private Date date_crea;
    
    public Client(){
        
    }
    
    public Client(int id){
        this.id = id;
    }
    
    public Client(int id, Set<Devis> devis, Paiement paiement, String nom, int telephone, String adresse, int cp, String ville, Date date_crea){
        this.id = id;
        this.devis = devis;
        this.paiement = paiement;
        this.nom = nom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.date_crea = date_crea;
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
     
    // GET AND SET DEVIS
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
     public Set<Devis> getDevis(){
         return this.devis;
     }
     
     public void setDevis(Set<Devis> devis){
         this.devis = devis;
     }
     
     // GET AND SET PAIEMENT
     @OneToOne(fetch=FetchType.LAZY, mappedBy="client")
     public Paiement getPaiement(){
         return this.paiement;
     }
     
     public void setPaiement(Paiement paiement){
         this.paiement = paiement;
     }
     
     // GET AND SET NOM
    @Column(name="nom", length=50)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    // GET AND SET TELEPHONE
    @Column(name="telephone", length=50)
    public Integer getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    // GET AND SET ADRESSE
    @Column(name="adresse", length=50)
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    // GET AND SET CODE POSTALE
    @Column(name="cp", length=50)
    public Integer getCp() {
        return this.cp;
    }
    
    public void setCp(int cp) {
        this.cp = cp;
    }
            
    // GET AND SET ADRESSE
    @Column(name="ville", length=50)
    public String getVille() {
        return this.ville;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
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
    
}
