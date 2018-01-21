/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dao;

import fr.viacesi.webservicewood.entity.Client;
import java.util.List;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Numalama
 */
public interface ClientDAO extends CrudRepository<Client, Long>{
    public abstract Client save(Client client);
    public abstract Client findById(Integer id);
    public abstract List<Client> findAll();
}
