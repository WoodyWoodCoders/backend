/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.ComposantDAO;
import fr.viacesi.webservicewood.dao.ModuleDAO;
import fr.viacesi.webservicewood.dto.ComposantDTO;
import fr.viacesi.webservicewood.entity.Composant;
import fr.viacesi.webservicewood.entity.ComposantInModule;
import fr.viacesi.webservicewood.entity.Module;
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
public class ComposantService {
    @Autowired
    private ComposantDAO composantDAO;
    
    @Autowired
    private ModuleDAO moduleDAO;
    

    public ComposantDTO creatComposant(Composant new_composant) {
            
            Composant composantDao = this.composantDAO.save(new_composant);  
            ModelMapper modelMapper = new ModelMapper();
            ComposantDTO composantDTO = modelMapper.map(composantDao, ComposantDTO.class);
            return composantDTO;
        }
 
    
        public void testComposant() {
            
            Composant composantA = new Composant("Composant A");

            Module moduleA = new Module("Module A");

            ComposantInModule composantInModule = new ComposantInModule();
            composantInModule.setComposant(composantA);
            composantInModule.setModule(moduleA);
            composantInModule.setDisposition("43");
            composantA.getComposantInModules().add(composantInModule);
            
            moduleDAO.save(moduleA);
            composantDAO.save(composantA);

            // test
            System.out.println(composantA.getComposantInModules().size());

            // update
            //composantA.getComposantInModules().remove(composantInModule);
            //composantDAO.save(composantA);

            // test
            System.out.println(composantA.getComposantInModules().size()); 
            
        }
        public List<Composant> getComposants(){
            return this.composantDAO.findAll();
        }
        
        public ComposantDTO getComposant(int id){
            Composant composantDao = this.composantDAO.findById(id); 
            ModelMapper modelMapper = new ModelMapper();
            ComposantDTO composantDTO = modelMapper.map(composantDao, ComposantDTO.class);
            return composantDTO;
        }
        
    public List<ComposantDTO> getComposantsDTO() {
        //GET AND RETURN LIST OF ALL DEVIS IN DB
        List<Composant> listComposantsDao = this.composantDAO.findAll();
        // Define the target type devisDTO
        java.lang.reflect.Type targetListType = new TypeToken<List<ComposantDTO>>() {
        }.getType();
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS LIST DAO TO DEVIS LIST DTO
        List<ComposantDTO> composantListDTO = modelMapper.map(listComposantsDao, targetListType);
        //return LIST OF DEVIS DTO
        return composantListDTO;

    }
        
        public ComposantDTO updateComposant(Composant composant){
            Composant composantDao = this.composantDAO.findById(composant.getId());
            composantDao.setNom(composant.getNom());
            composantDao.setDimensions(composant.getDimensions());
            composantDao.setPrix(composant.getPrix());
            composantDao.setGamme(composant.getGamme());
            composantDao.setPrix(composant.getPrix());
            this.composantDAO.save(composantDao);
            ModelMapper modelMapper = new ModelMapper();
            ComposantDTO compostantDTO = modelMapper.map(composantDao, ComposantDTO.class);
            return compostantDTO;
        }
        
        public boolean deleteComposant(int id){
            Composant composantDAO = this.composantDAO.findById(id);
            this.composantDAO.delete(composantDAO);
            return true;
        }
}
