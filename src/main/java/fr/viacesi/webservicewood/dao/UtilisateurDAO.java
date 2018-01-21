/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.dao;

import fr.viacesi.webservicewood.entity.Utilisateur;
import java.util.List;
import static org.json.XMLTokener.entity;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Numalama
 */
public interface UtilisateurDAO extends CrudRepository<Utilisateur, Long> {

    public abstract Utilisateur findById(int id);

    public abstract Utilisateur findByLogin(String Login);

    public abstract boolean existsByLogin(String Login);

    public abstract boolean existsByLoginAndPassword(String Login, String password);

    public abstract Utilisateur save(Utilisateur user);

}
