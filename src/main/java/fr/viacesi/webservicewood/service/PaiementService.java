/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.ClientDAO;
import fr.viacesi.webservicewood.dao.DevisDAO;
import fr.viacesi.webservicewood.dao.ModuleDAO;
import fr.viacesi.webservicewood.dao.PaiementDAO;
import fr.viacesi.webservicewood.dto.PaiementDTO;
import fr.viacesi.webservicewood.entity.Client;
import fr.viacesi.webservicewood.entity.Devis;
import fr.viacesi.webservicewood.entity.Paiement;
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
public class PaiementService {
    @Autowired
    private PaiementDAO paiementDAO;
    @Autowired
    private ClientDAO clientDAO; 
    @Autowired
    private DevisDAO devistDAO;
    
     public PaiementDTO creatPaiement(Paiement new_paiement) {
            Paiement paiement = new_paiement;
            Client clientDao = this.clientDAO.findById(new_paiement.getClient().getId());
            Devis devisDao = this.devistDAO.findById(new_paiement.getDevis().getId());
            paiement.setClient(clientDao);
            paiement.setDevis(devisDao);
            Paiement paiementDao = this.paiementDAO.save(paiement);  
            ModelMapper modelMapper = new ModelMapper();
            PaiementDTO paiementDTO = modelMapper.map(paiementDao, PaiementDTO.class);
            return paiementDTO;
        }
        
        public List<Paiement> getPaiements(){
            return this.paiementDAO.findAll();
        }
        
        public PaiementDTO getPaiement(int id){
            Paiement paiementDao = this.paiementDAO.findById(id); 
            ModelMapper modelMapper = new ModelMapper();
            PaiementDTO paiementDTO = modelMapper.map(paiementDao, PaiementDTO.class);
            return paiementDTO;
        }
        
        public List<PaiementDTO> getPaiementsDTO() {
            //GET AND RETURN LIST OF ALL DEVIS IN DB
            List<Paiement> listPaiementsDao = this.paiementDAO.findAll();
            // Define the target type devisDTO
            java.lang.reflect.Type targetListType = new TypeToken<List<PaiementDTO>>() {
            }.getType();
            // NEW MAPPER
            ModelMapper modelMapper = new ModelMapper();
            // MAP DEVIS LIST DAO TO DEVIS LIST DTO
            List<PaiementDTO> paiementListDTO = modelMapper.map(listPaiementsDao, targetListType);
            //return LIST OF DEVIS DTO
            return paiementListDTO;

        }
        
        public PaiementDTO updatePaiement(Paiement paiement){
            Paiement paiementDao = this.paiementDAO.findById(paiement.getId());
            paiementDao.setMontant(paiement.getMontant());
            paiementDao.setMoyen(paiement.getMoyen());
            paiementDao.setDevis(paiement.getDevis());
            paiementDao.setClient(paiement.getClient());
            this.paiementDAO.save(paiementDao);
            ModelMapper modelMapper = new ModelMapper();
            PaiementDTO paiementDTO = modelMapper.map(paiementDao, PaiementDTO.class);
            return paiementDTO;
        }
        
        public boolean deletePaiement(int id){
            Paiement paiementDao = this.paiementDAO.findById(id);
            this.paiementDAO.delete(paiementDao);
            return true;
        }
}
