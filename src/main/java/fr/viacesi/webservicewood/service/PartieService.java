/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.DevisDAO;
import fr.viacesi.webservicewood.dao.ModuleDAO;
import fr.viacesi.webservicewood.dao.PartieDAO;
import fr.viacesi.webservicewood.dto.ModuleDTO;
import fr.viacesi.webservicewood.dto.PartieDTO;
import fr.viacesi.webservicewood.entity.Devis;
import fr.viacesi.webservicewood.entity.Module;
import fr.viacesi.webservicewood.entity.ModuleInPartie;
import fr.viacesi.webservicewood.entity.Partie;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1797531
 */
@Service
public class PartieService {
    @Autowired
    private PartieDAO partieDAO;
    @Autowired
    private ModuleDAO moduleDAO; 
    @Autowired
    private DevisDAO devisDAO;
    
    
     public PartieDTO creatPartie(Partie new_partie) {
            
            Partie partie = new_partie;
            Devis devisDao = this.devisDAO.findById(new_partie.getDevis().getId());
            partie.setDevis(devisDao);
            Partie partieDao = this.partieDAO.save(partie);
            ModelMapper modelMapper = new ModelMapper();
            PartieDTO partieDTO = modelMapper.map(partieDao, PartieDTO.class);
            return partieDTO;
        }
        
        public List<Partie> getParties(){
            return this.partieDAO.findAll();
        }
        
        public PartieDTO getPartie(int id){
            Partie partieDao = this.partieDAO.findById(id); 
            ModelMapper modelMapper = new ModelMapper();
            PartieDTO partieDTO = modelMapper.map(partieDao, PartieDTO.class);
            return partieDTO;
        }
        
        public List<PartieDTO> getPartiesDTO() {
            //GET AND RETURN LIST OF ALL DEVIS IN DB
            List<Partie> listPartiesDao = this.partieDAO.findAll();
            // Define the target type devisDTO
            java.lang.reflect.Type targetListType = new TypeToken<List<PartieDTO>>() {
            }.getType();
            // NEW MAPPER
            ModelMapper modelMapper = new ModelMapper();
            // MAP DEVIS LIST DAO TO DEVIS LIST DTO
            List<PartieDTO> partieListDTO = modelMapper.map(listPartiesDao, targetListType);
            //return LIST OF DEVIS DTO
            return partieListDTO;

        }
        
        public List<ModuleDTO> getModuleInpartieDTO(int id) {

        Partie partieDao = this.partieDAO.findById(id);

        int index = partieDao.getModuleInParties().size();

        Set<ModuleInPartie> listModuleInParties = partieDao.getModuleInParties();
        List<Module> listModuleDao = new ArrayList<Module>();
        for (ModuleInPartie mip : listModuleInParties) {
            System.out.println("valeur de module");
            System.out.println(mip.getModule());
            listModuleDao.add(mip.getModule());
        }
        
        // Define the target type devisDTO
        java.lang.reflect.Type targetListType = new TypeToken<List<ModuleDTO>>() {
        }.getType();
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS LIST DAO TO DEVIS LIST DTO
        List<ModuleDTO> moduleListDTO = modelMapper.map(listModuleDao, targetListType);
        //return LIST OF DEVIS DTO
        return moduleListDTO;
        
    }
        
    public List<ModuleDTO> setModuleInpartieDTO(int id_partie, int id_module, String disposition) {
        Partie partieDao = this.partieDAO.findById(id_partie);
        Module moduleDao = this.moduleDAO.findById(id_module);

        
        ModuleInPartie moduleInPartie = new ModuleInPartie();
        moduleInPartie.setPartie(partieDao);
        moduleInPartie.setModule(moduleDao);
        moduleInPartie.setDisposition(disposition);
        
        moduleDao.getModuleInParties().add(moduleInPartie);
        
        this.partieDAO.save(partieDao);
        this.moduleDAO.save(moduleDao);

        
        int index = moduleDao.getComposantInModules().size();

        Set<ModuleInPartie> listModuleInParties = partieDao.getModuleInParties();
        List<Module> listModuleDao = new ArrayList<Module>();
        for (ModuleInPartie mip : listModuleInParties) {
            System.out.println("valeur de module");
            System.out.println(mip.getModule());
            listModuleDao.add(mip.getModule());
        }
        
        // Define the target type devisDTO
        java.lang.reflect.Type targetListType = new TypeToken<List<ModuleDTO>>() {
        }.getType();
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS LIST DAO TO DEVIS LIST DTO
        List<ModuleDTO> moduleListDTO = modelMapper.map(listModuleDao, targetListType);
        //return LIST OF DEVIS DTO
        return moduleListDTO;
        
    }
        
        public PartieDTO updatePartie(Partie partie){
            Partie partieDao = this.partieDAO.findById(partie.getId());
            partieDao.setNom(partie.getNom());
            partieDao.setDisposition(partie.getDisposition());
            partieDao.setDevis(partie.getDevis());
            partieDao.setModuleInParties(partie.getModuleInParties());
            this.partieDAO.save(partieDao);
            ModelMapper modelMapper = new ModelMapper();
            PartieDTO compostantDTO = modelMapper.map(partieDao, PartieDTO.class);
            return compostantDTO;
        }
        
        public boolean deletePartie(int id){
            Partie partieDAO = this.partieDAO.findById(id);
            this.partieDAO.delete(partieDAO);
            return true;
        }
}
