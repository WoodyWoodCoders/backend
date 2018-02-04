/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.UtilisateurDAO;
import fr.viacesi.webservicewood.dto.UtilisateurDTO;
import fr.viacesi.webservicewood.entity.Devis;
import fr.viacesi.webservicewood.entity.Utilisateur;
import java.util.Iterator;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Numalama
 */
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurDAO utilisateurDAO;

    public Utilisateur findById(int id) {
        return utilisateurDAO.findById(id);
    }

    public Utilisateur saveUtilisateurChanges(Utilisateur utilisateur) {

        Utilisateur user = this.utilisateurDAO.findById(utilisateur.getId());
        utilisateurDAO.save(user);
        System.out.println("sauvegarde ok");
        return user;

    }

    public UtilisateurDTO ChangeUtilisateurLogin(UtilisateurDTO currentUser, String newLogin) {

        Utilisateur user = this.utilisateurDAO.findById(currentUser.getId());
        user.setLogin(newLogin);
        utilisateurDAO.save(user);
        //Mapper DTO -> Entity
        ModelMapper modelMapper = new ModelMapper();
        UtilisateurDTO utilisateurDTO = modelMapper.map(user, UtilisateurDTO.class);
        
        System.out.println("Login change ok");
        return utilisateurDTO;
    }

    public Boolean utilisateurExist(Utilisateur utilisateur) {

        return this.utilisateurDAO.existsByLoginAndPassword(utilisateur.getLogin(), utilisateur.getPassword());
    }

    public Boolean utilisateurExistByNickname(Utilisateur utilisateur) {

        return this.utilisateurDAO.existsByLogin(utilisateur.getLogin());
    }

    public Utilisateur getUtilisateurProfile(Utilisateur utilisateur) {

        Utilisateur user = this.utilisateurDAO.findById(utilisateur.getId());
        return user;
    }

    public Utilisateur getUserByNickname(String login) {

        return this.utilisateurDAO.findByLogin(login);

    }

    public String creatUtilisateur(Utilisateur utilisateur) {

        //Création d'un nouveau user
        Utilisateur new_user = new Utilisateur();
        new_user.setLogin(utilisateur.getLogin());
        new_user.setNom(utilisateur.getNom());
        new_user.setPassword(utilisateur.getPassword());
        new_user.setType(utilisateur.getType());

        //save du user en base de données afin de lui attribuer un id
        utilisateurDAO.save(new_user);

        return "Utilisateur creer avec succès";

    }

}
