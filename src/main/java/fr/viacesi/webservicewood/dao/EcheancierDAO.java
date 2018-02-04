/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dao;

import fr.viacesi.webservicewood.entity.Echeancier;
import fr.viacesi.webservicewood.entity.Module;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 1797531
 */
public interface EcheancierDAO extends CrudRepository<Echeancier, Long>{
    public abstract Echeancier save(Echeancier echeancier);
    public abstract Echeancier findById(Integer id);
    public abstract List<Echeancier> findAll();
    public abstract void delete(Echeancier echeancier);
}
