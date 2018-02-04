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
import fr.viacesi.webservicewood.dto.PartieDTO;
import fr.viacesi.webservicewood.dto.UtilisateurDTO;
import fr.viacesi.webservicewood.entity.Client;
import fr.viacesi.webservicewood.entity.Devis;
import fr.viacesi.webservicewood.entity.Partie;
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

    public DevisDTO creatDevis(UtilisateurDTO current_user, Devis new_devis) {
            Devis devis = new_devis;
            Client clientDao = this.clientDAO.findById(new_devis.getClient().getId());
            Utilisateur utilisateurDao = this.utilisateurDAO.findById(current_user.getId());
            devis.setClient(clientDao);
            devis.setUtilisateur(utilisateurDao);
            Devis devisDao = this.devisDAO.save(devis);
            ModelMapper modelMapper = new ModelMapper();
            DevisDTO devisDTO = modelMapper.map(devisDao, DevisDTO.class);
            return devisDTO;
    }
    
    public DevisListDTO getUserDevis(UtilisateurDTO current_user){
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
