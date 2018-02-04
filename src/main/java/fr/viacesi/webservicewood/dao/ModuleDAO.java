/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dao;

import fr.viacesi.webservicewood.entity.Composant;
import fr.viacesi.webservicewood.entity.Module;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 1797531
 */
public interface ModuleDAO extends CrudRepository<Module, Long>{
    public abstract Module save(Module module);
    public abstract Module findById(Integer id);
    public abstract List<Module> findAll();
    public abstract void delete(Module module);
}
