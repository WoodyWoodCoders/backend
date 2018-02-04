/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.ComposantDAO;
import fr.viacesi.webservicewood.dao.ModuleDAO;
import fr.viacesi.webservicewood.dao.ModuleDAO;
import fr.viacesi.webservicewood.dto.ComposantDTO;
import fr.viacesi.webservicewood.dto.ModuleDTO;
import fr.viacesi.webservicewood.entity.Composant;
import fr.viacesi.webservicewood.entity.ComposantInModule;
import fr.viacesi.webservicewood.entity.Module;
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
public class ModuleService {

    @Autowired
    private ModuleDAO moduleDAO;

    @Autowired
    private ComposantDAO composantDAO;
    
    
    public ModuleDTO creatModule(Module new_module) {
        Module moduleDao = this.moduleDAO.save(new_module);
        ModelMapper modelMapper = new ModelMapper();
        ModuleDTO moduleDTO = modelMapper.map(moduleDao, ModuleDTO.class);
        return moduleDTO;
    }

    public List<Module> getModules() {
        return this.moduleDAO.findAll();
    }

    public ModuleDTO getModule(int id) {
        Module moduleDao = this.moduleDAO.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        ModuleDTO moduleDTO = modelMapper.map(moduleDao, ModuleDTO.class);
        return moduleDTO;
    }

    public List<ModuleDTO> getModulesDTO() {
        //GET AND RETURN LIST OF ALL DEVIS IN DB
        List<Module> listModulesDao = this.moduleDAO.findAll();
        // Define the target type devisDTO
        java.lang.reflect.Type targetListType = new TypeToken<List<ModuleDTO>>() {
        }.getType();
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS LIST DAO TO DEVIS LIST DTO
        List<ModuleDTO> moduleListDTO = modelMapper.map(listModulesDao, targetListType);
        //return LIST OF DEVIS DTO
        return moduleListDTO;

    }

    public List<ComposantDTO> getComposantsInModuleDTO(int id) {

        Module moduleDao = this.moduleDAO.findById(id);

        int index = moduleDao.getComposantInModules().size();

        Set<ComposantInModule> listComposantInModule = moduleDao.getComposantInModules();
        ComposantInModule composantInModule = new ComposantInModule();
        List<Composant> listComposantDao = new ArrayList<Composant>();
        for (ComposantInModule cim : listComposantInModule) {
            System.out.println("valeur du composant");
            System.out.println(cim.getComposant());
            listComposantDao.add(cim.getComposant());
        }
        
        // Define the target type devisDTO
        java.lang.reflect.Type targetListType = new TypeToken<List<ComposantDTO>>() {
        }.getType();
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS LIST DAO TO DEVIS LIST DTO
        List<ComposantDTO> composantListDTO = modelMapper.map(listComposantDao, targetListType);
        //return LIST OF DEVIS DTO
        return composantListDTO;
        
    }
    
        public List<ComposantDTO> setComposantsInModuleDTO(int id_module, int id_composant, String disposition) {

        Module moduleDao = this.moduleDAO.findById(id_module);
        Composant composantDao = this.composantDAO.findById(id_composant);
        
        ComposantInModule composantInModule = new ComposantInModule();
        composantInModule.setComposant(composantDao);
        composantInModule.setModule(moduleDao);
        composantInModule.setDisposition(disposition);
        
        composantDao.getComposantInModules().add(composantInModule);
        
        this.moduleDAO.save(moduleDao);
        this.composantDAO.save(composantDao);
        
        int index = moduleDao.getComposantInModules().size();

        Set<ComposantInModule> listComposantInModule = moduleDao.getComposantInModules();
        
        List<Composant> listComposantDao = new ArrayList<Composant>();
        for (ComposantInModule cim : listComposantInModule) {
            System.out.println("valeur du composant");
            System.out.println(cim.getComposant());
            listComposantDao.add(cim.getComposant());
        }
        
        // Define the target type devisDTO
        java.lang.reflect.Type targetListType = new TypeToken<List<ComposantDTO>>() {
        }.getType();
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS LIST DAO TO DEVIS LIST DTO
        List<ComposantDTO> composantListDTO = modelMapper.map(listComposantDao, targetListType);
        //return LIST OF DEVIS DTO
        return composantListDTO;
        
    }
    public List<ComposantDTO> setAndCreatComposantsInModuleDTO(int id, ComposantInModule newcomposantInModule) {

        Module moduleDao = this.moduleDAO.findById(id);
        ComposantInModule composantInModule = new ComposantInModule();
        Composant composant = newcomposantInModule.getComposant();
        composantInModule.setComposant(composant);
        composantInModule.setModule(moduleDao);
        composantInModule.setDisposition("43");
        moduleDao.getComposantInModules().add(composantInModule);
        
        int index = moduleDao.getComposantInModules().size();

        Set<ComposantInModule> listComposantInModule = moduleDao.getComposantInModules();
        
        List<Composant> listComposantDao = new ArrayList<Composant>();
        for (ComposantInModule cim : listComposantInModule) {
            System.out.println("valeur du composant");
            System.out.println(cim.getComposant());
            listComposantDao.add(cim.getComposant());
        }
        
        // Define the target type devisDTO
        java.lang.reflect.Type targetListType = new TypeToken<List<ComposantDTO>>() {
        }.getType();
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS LIST DAO TO DEVIS LIST DTO
        List<ComposantDTO> composantListDTO = modelMapper.map(listComposantDao, targetListType);
        //return LIST OF DEVIS DTO
        return composantListDTO;
        
    }

    public ModuleDTO updateModule(Module module) {
        Module moduleDao = this.moduleDAO.findById(module.getId());
        moduleDao.setNom(module.getNom());
        moduleDao.setDimension(module.getDimension());
        moduleDao.setPrix(module.getPrix());
        moduleDao.setPrix(module.getPrix());
        this.moduleDAO.save(moduleDao);
        ModelMapper modelMapper = new ModelMapper();
        ModuleDTO compostantDTO = modelMapper.map(moduleDao, ModuleDTO.class);
        return compostantDTO;
    }

    public boolean deleteModule(int id) {
        Module moduleDAO = this.moduleDAO.findById(id);
        this.moduleDAO.delete(moduleDAO);
        return true;
    }
}
