/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.entity;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mgonzalez
 */
@Entity
@Table(name = "utilisateur"
)
public class Utilisateur implements java.io.Serializable {

    private int id;
    private int type;
    private String nom;
    private String login;
    private String password;
    private Set<Devis> devis = new HashSet<Devis>(0);

    public Utilisateur() {
    }

    public Utilisateur(int id) {
        this.id = id;
    }

    public Utilisateur(int id, int type, String nom, String login, String password, Set<Devis> devis) {
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.login = login;
        this.password = password;
        this.devis = devis;
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

    // GET AND SET TYPE
    @Column(name = "type")
    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // GET AND SET NOM
    @Column(name = "nom", length = 50, unique = true)
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // GET AND SET LOGIN
    @Column(name = "login", length = 50, unique = true)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // GET AND SET PASSWORD
    @Column(name = "password", length = 255)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // GET AND SET DEVIS
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utilisateur")
    public Set<Devis> getDevis() {
        return this.devis;
    }

    public void setDevis(Set<Devis> devis) {
        this.devis = devis;
    }
}
