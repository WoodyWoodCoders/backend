/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.ClientDAO;
import fr.viacesi.webservicewood.dto.ClientDTO;
import fr.viacesi.webservicewood.dto.ClientListDTO;
import fr.viacesi.webservicewood.dto.DevisDTO;
import fr.viacesi.webservicewood.entity.Client;
import fr.viacesi.webservicewood.entity.Devis;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Numalama
 */
@Service
public class ClientService {
    @Autowired
    private ClientDAO clientDAO;
    
        public ClientDTO creatClient(Client new_client) {
            Client clientDao = this.clientDAO.save(new_client);  
            ModelMapper modelMapper = new ModelMapper();
            ClientDTO clientDTO = modelMapper.map(clientDao, ClientDTO.class);
            return clientDTO;
        }
        
        public List<Client> getClients(){
            return this.clientDAO.findAll();
        }
        
        public ClientDTO getClient(int id){
            Client clientDao = this.clientDAO.findById(id); 
            ModelMapper modelMapper = new ModelMapper();
            ClientDTO clientDTO = modelMapper.map(clientDao, ClientDTO.class);
            return clientDTO;
        }
        
    public List<ClientDTO> getClientsDTO() {
        //GET AND RETURN LIST OF ALL DEVIS IN DB
        List<Client> listClientsDao = clientDAO.findAll();
        // Define the target type devisDTO
        java.lang.reflect.Type targetListType = new TypeToken<List<ClientDTO>>() {
        }.getType();
        // NEW MAPPER
        ModelMapper modelMapper = new ModelMapper();
        // MAP DEVIS LIST DAO TO DEVIS LIST DTO
        List<ClientDTO> clientListDTO = modelMapper.map(listClientsDao, targetListType);
        //return LIST OF DEVIS DTO
        return clientListDTO;

    }
        
        public ClientDTO updateClient(Client client){
            Client clientDao = this.clientDAO.findById(client.getId());
            clientDao.setNom(client.getNom());
            clientDao.setAdresse(client.getAdresse());
            clientDao.setCp(client.getCp());
            clientDao.setVille(client.getVille());
            clientDao.setTelephone(client.getTelephone());
            clientDAO.save(clientDao);
            ModelMapper modelMapper = new ModelMapper();
            ClientDTO clientDTO = modelMapper.map(clientDao, ClientDTO.class);
            return clientDTO;
        }
        
        public boolean deleteClient(int id){
            Client clientDAO = this.clientDAO.findById(id);
            this.clientDAO.delete(clientDAO);
            return true;
        }
      
        
        
        
        
}
