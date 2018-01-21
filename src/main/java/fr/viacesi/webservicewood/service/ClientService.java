/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.viacesi.webservicewood.service;

import fr.viacesi.webservicewood.dao.ClientDAO;
import fr.viacesi.webservicewood.dto.ClientDTO;
import fr.viacesi.webservicewood.dto.ClientListDTO;
import fr.viacesi.webservicewood.entity.Client;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
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
            Client clientDao = clientDAO.save(new_client);  
            ModelMapper modelMapper = new ModelMapper();
            ClientDTO clientDTO = modelMapper.map(clientDao, ClientDTO.class);
            return clientDTO;
        }
        
        public List<Client> getClients(){
            return clientDAO.findAll();
        }
        
        
        
}
