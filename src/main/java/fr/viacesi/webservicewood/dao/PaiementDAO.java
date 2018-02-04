/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dao;

import fr.viacesi.webservicewood.entity.Paiement;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 1797531
 */
public interface PaiementDAO extends CrudRepository<Paiement, Long>{
    public abstract Paiement save(Paiement paiement);
    public abstract Paiement findById(Integer id);
    public abstract List<Paiement> findAll();
    public abstract void delete(Paiement paiement);
}
