/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dao;

import fr.viacesi.webservicewood.entity.Client;
import fr.viacesi.webservicewood.entity.Composant;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 1797531
 */
public interface ComposantDAO extends CrudRepository<Composant, Long>{
    public abstract Composant save(Composant composant);
    public abstract Composant findById(Integer id);
    public abstract List<Composant> findAll();
    public abstract void delete(Composant composant);
}
