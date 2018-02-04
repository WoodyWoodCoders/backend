/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dao;

import fr.viacesi.webservicewood.entity.Module;
import fr.viacesi.webservicewood.entity.Partie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 1797531
 */
public interface PartieDAO extends CrudRepository<Partie, Long>{
    public abstract Partie save(Partie partie);
    public abstract Partie findById(Integer id);
    public abstract List<Partie> findAll();
    public abstract void delete(Partie partie);
}
