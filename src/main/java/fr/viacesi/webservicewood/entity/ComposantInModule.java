/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Numalama
 */
@Entity
@Table(name="composant_in_module")
public class ComposantInModule implements Serializable {
    private Module module;
    private Composant composant;
    private String disposition;

    
    public ComposantInModule(){
        
    }
    
    public ComposantInModule( Module module, Composant composant,  String disposition){
        this.module = module;
        this.composant = composant;
        this.disposition = disposition;
    }
    

     //GET AND SET MODULE
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "module_id")
    public Module getModule() {
        return this.module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
    
    //GET AND SET COMPOSANT
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "composant_id")
    public Composant getComposant() {
        return this.composant;
    }

    public void setComposant(Composant composant) {
        this.composant = composant;
    }

    // GET AND SET DISPOSITION
    @Column(name = "disposition")
    public String getDisposition() {
        return this.disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

}
