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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Numalama
 */
@Entity
@Table(name="module_in_partie")
public class ModuleInPartie implements Serializable {
    private Partie partie;
    private Module module;
    private String disposition;

    
    public ModuleInPartie(){
        
    }
    
     
     public ModuleInPartie(Partie partie, Module module, String disposition){
        this.partie = partie;
        this.module = module;
        this.disposition = disposition;
    }
    
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "partie_id")
    public Partie getPartie() {
        return this.partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "module_id")
    public Module getModule() {
        return this.module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Column(name = "disposition")
    public String getDisposition() {
        return this.disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }
}
