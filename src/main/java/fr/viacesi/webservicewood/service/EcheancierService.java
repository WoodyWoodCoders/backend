/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.DevisDAO;
import fr.viacesi.webservicewood.dao.EcheancierDAO;
import fr.viacesi.webservicewood.dto.EcheancierDTO;
import fr.viacesi.webservicewood.entity.Devis;
import fr.viacesi.webservicewood.entity.Echeancier;
import fr.viacesi.webservicewood.entity.Partie;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1797531
 */
@Service
public class EcheancierService {
    @Autowired
    private EcheancierDAO echeancierDAO;
    @Autowired
    private DevisDAO devisDAO;
    
     public EcheancierDTO creatEcheancier(Echeancier new_echeancier) {
            Echeancier echeancier = new_echeancier;
            Devis devisDao = this.devisDAO.findById(new_echeancier.getDevis().getId());
            echeancier.setDevis(devisDao);
            Echeancier echeancierDao = this.echeancierDAO.save(echeancier);  
            ModelMapper modelMapper = new ModelMapper();
            EcheancierDTO echeancierDTO = modelMapper.map(echeancierDao, EcheancierDTO.class);
            return echeancierDTO;
        }
        
        public List<Echeancier> getEcheanciers(){
            return this.echeancierDAO.findAll();
        }
        
        public EcheancierDTO getEcheancier(int id){
            Echeancier echeancierDao = this.echeancierDAO.findById(id); 
            ModelMapper modelMapper = new ModelMapper();
            EcheancierDTO echeancierDTO = modelMapper.map(echeancierDao, EcheancierDTO.class);
            return echeancierDTO;
        }
        
        public List<EcheancierDTO> getEcheanciersDTO() {
            //GET AND RETURN LIST OF ALL DEVIS IN DB
            List<Echeancier> listEcheanciersDao = this.echeancierDAO.findAll();
            // Define the target type devisDTO
            java.lang.reflect.Type targetListType = new TypeToken<List<EcheancierDTO>>() {
            }.getType();
            // NEW MAPPER
            ModelMapper modelMapper = new ModelMapper();
            // MAP DEVIS LIST DAO TO DEVIS LIST DTO
            List<EcheancierDTO> echeancierListDTO = modelMapper.map(listEcheanciersDao, targetListType);
            //return LIST OF DEVIS DTO
            return echeancierListDTO;

        }
        
        public EcheancierDTO updateEcheancier(Echeancier partie){
            Echeancier echeancierDao = this.echeancierDAO.findById(partie.getId());
            echeancierDao.setDevis(partie.getDevis());
            echeancierDao.setNbMois(partie.getNbMois());
            echeancierDao.setJourDuMois(partie.getJourDuMois());
            echeancierDao.setNbPaiements(partie.getNbPaiements());
            echeancierDao.setMontantPaiement(partie.getMontantPaiement());
            this.echeancierDAO.save(echeancierDao);
            ModelMapper modelMapper = new ModelMapper();
            EcheancierDTO echeancierDTO = modelMapper.map(echeancierDao, EcheancierDTO.class);
            return echeancierDTO;
        }
        
        public boolean deleteEcheancier(int id){
            Echeancier echeancierao = this.echeancierDAO.findById(id);
            this.echeancierDAO.delete(echeancierao);
            return true;
        }
}
