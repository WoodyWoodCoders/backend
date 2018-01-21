/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.ClientDAO;
import fr.viacesi.webservicewood.dao.DevisDAO;
import fr.viacesi.webservicewood.dao.UtilisateurDAO;
import fr.viacesi.webservicewood.dto.DevisDTO;
import fr.viacesi.webservicewood.dto.DevisListDTO;
import fr.viacesi.webservicewood.entity.Devis;
import fr.viacesi.webservicewood.entity.Utilisateur;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Numalama
 */
@Service
public class DevisService {

    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @Autowired
    private DevisDAO devisDAO;
    
    @Autowired
    private ClientDAO clientDAO;

    public DevisDTO creatDevis(Utilisateur current_user, Devis new_devis) {
        //GET USER IN DB
        Utilisateur userDao = utilisateurDAO.findById(current_user.getId());
        // SET A USER TO THE NEW DEVIS BEFORE PUSH
        new_devis.setUtilisateur(userDao);
        // SAVE THE NEW DEVIS IN THE DB WITH DEVISDAO
        devisDAO.save(new_devis);
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS DAO TO DEVIS DTO
        DevisDTO devisDTO = modelMapper.map(new_devis, DevisDTO.class);
        return devisDTO;
    }
    
    public DevisListDTO getUserDevis(Utilisateur current_user){
        //GET USER IN DB
        Utilisateur userDao = utilisateurDAO.findById(current_user.getId());
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP LIST OF USER DEVIS DAO TO LIST OF USER DTO
        DevisListDTO devisListDTO = modelMapper.map(userDao, DevisListDTO.class);
        return devisListDTO;
    }
    
    public List<Devis> getAllDevisDAO(){      
       //GET AND RETURN LIST OF ALL DEVIS IN DB
       List<Devis> listDevisDao =  devisDAO.findAll();
       //RETURN LIST OF DEVIS DAO
       return listDevisDao;
      
    }
    
     public List<DevisDTO> getAllDevisDTO(){    
       //GET AND RETURN LIST OF ALL DEVIS IN DB
       List<Devis> listDevisDao =  devisDAO.findAll();
        // Define the target type devisDTO
       java.lang.reflect.Type targetListType = new TypeToken<List<DevisDTO>>() {}.getType();
       // NEW MAPPER
       ModelMapper modelMapper = new ModelMapper();
       // MAP DEVIS LIST DAO TO DEVIS LIST DTO
       List<DevisDTO> devisListDTO = modelMapper.map(listDevisDao, targetListType);
       //return LIST OF DEVIS DTO
       return devisListDTO;
      
    }
    
}
