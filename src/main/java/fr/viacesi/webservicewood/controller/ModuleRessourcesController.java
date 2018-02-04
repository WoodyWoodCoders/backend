/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.controller;

import fr.viacesi.webservicewood.dto.ComposantDTO;
import fr.viacesi.webservicewood.dto.ModuleDTO;
import fr.viacesi.webservicewood.entity.Composant;
import fr.viacesi.webservicewood.entity.ComposantInModule;
import fr.viacesi.webservicewood.entity.Module;
import fr.viacesi.webservicewood.http.Response;
import fr.viacesi.webservicewood.service.ComposantService;
import fr.viacesi.webservicewood.service.ModuleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 1797531
 */
@RestController
@RequestMapping("/rest/module")
public class ModuleRessourcesController extends AbstractSecureController{
    @Autowired
    private ModuleService moduleService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModuleDTO createModule(@RequestBody Module module) {
        return moduleService.creatModule(module);
    }
    
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Module> getModules() {  
        return moduleService.getModules();
    }
    
    @RequestMapping(value = "/get/all/dto", method = RequestMethod.GET)
    public List<ModuleDTO> getModulesDTO() {  
        return moduleService.getModulesDTO();
    }
    
    // get 1 client
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ModuleDTO getModule(@PathVariable("id") int id) {  
        System.out.println("id : " + id);
        return moduleService.getModule(id);
    }
    
    // get 1 client
    @RequestMapping(value = "/get/all/composants/{id}", method = RequestMethod.GET)
    public List<ComposantDTO> getComposantInModule(@PathVariable("id") int id) {  
        System.out.println("id : " + id);
         return moduleService.getComposantsInModuleDTO(id);
    }
    
    // get 1 client
    @RequestMapping(value = "/set/composant/", method = RequestMethod.POST)
    public List<ComposantDTO> SetComposantInModule(@RequestBody ComposantInModule composantInModule) {  
        return moduleService.setComposantsInModuleDTO(composantInModule.getModule().getId(), composantInModule.getComposant().getId(), composantInModule.getDisposition() );
    }
    // edit client
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModuleDTO updateModule(@RequestBody Module module) {  
        return moduleService.updateModule(module);
    }
    
    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> deleteModule(@PathVariable("id") int id) {  
      boolean response = moduleService.deleteModule(id);
      return this.responseSuccess(response);
    }
   
 
}
