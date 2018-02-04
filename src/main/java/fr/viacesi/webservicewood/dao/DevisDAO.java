/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dao;

import fr.viacesi.webservicewood.entity.Devis;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Numalama
 */
public interface DevisDAO extends CrudRepository<Devis, Long> {

    public abstract Devis findById(int id);
    //Devis findByNom(String Nom);
    //boolean existByNom(String Nom);
    //boolean existById(int id);
    public abstract Devis save(Devis devis);
    public abstract List<Devis> findAll();
}
