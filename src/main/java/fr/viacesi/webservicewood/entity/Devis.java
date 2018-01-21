/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mgonzalez
 */
@Entity
@Table(name = "devis"
)
public class Devis implements java.io.Serializable {

    private int id;
    private Echeancier echeancier;
    private Utilisateur utilisateur;
    private Date date_crea;
    private String nom;
    private String reference;
    private int status;
    private Client client;
    private Set<Paiement> paiements = new HashSet<Paiement>(0);
    private Set<Partie> partis = new HashSet<Partie>(0);

    public Devis() {

    }

    public Devis(int id) {
        this.id = id;
    }

    public Devis(int id, Echeancier echeancier, Utilisateur utilisateur, Date date_crea, String nom, String reference, int status, Client client, Set<Paiement> paiements, Set<Partie> partis) {
        this.id = id;
        this.echeancier = echeancier;
        this.utilisateur = utilisateur;
        this.date_crea = date_crea;
        this.nom = nom;
        this.reference = reference;
        this.status = status;
        this.client = client;
        this.paiements = paiements;
        this.partis = partis;
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
    
    // GET AND SET ECHEANCIER
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "devis")
    @JoinColumn( nullable = false)
    public Echeancier getEcheancier() {
        return this.echeancier;
    }

    public void setEcheancier(Echeancier echeancier) {
        this.echeancier = echeancier;
    }

    // GET AND SET UTILISATEUR
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // GET AND SET DATE_CREA
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_crea")
    public Date getDateCrea() {
        return this.date_crea;
    }

    public void setDateCrea(Date date_crea) {
        this.date_crea = date_crea;
    }

    //GET AND SET NOM
    @Column(name = "nom", length = 50)
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // GET AND SET REFERENCE
    @Column(name = "reference", length = 50)
    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    // GET AND SET STATUS
    @Column(name = "status")
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // GET AND SET CLIENT
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id" , nullable = false)
    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // GET AND SET PAIEMENT
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "devis")
    public Set<Paiement> getPaiements() {
        return this.paiements;
    }

    public void setPaiements(Set<Paiement> paiements) {
        this.paiements = paiements;
    }

    // GET AND SET PARTIS
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "devis")
    public Set<Partie> getPartis() {
        return this.partis;
    }

    public void setPartis(Set<Partie> partis) {
        this.partis = partis;
    }

}
