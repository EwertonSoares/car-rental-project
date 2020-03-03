package com.car.rental.project.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.project.api.entities.Client;
import com.car.rental.project.api.services.ClientServices;

@RestController
@CrossOrigin(origins = "*")
public class ClientController {
		
	@Autowired
	private ClientServices clientServices;
	
	
	/**
	 * Retorna uma lista com todos clents
	 */	
   @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> Get() {
	   
	   return clientServices.findAll();
    }
	
   
   
	/**
	 * Encontra um client por CPF
	 * ou CNPJ 
	 * @Param name
	 * @return ResponseEntity<Client>
	 */
    @RequestMapping(value = "/clients/{doc}", method = RequestMethod.GET)
    public ResponseEntity<Client> GetClientByDoc(@PathVariable(value = "doc") String doc)
    {
    	Optional<Client> client = clientServices.findByDoc(doc);
         
        if(client.isPresent())
            return new ResponseEntity<Client>(client.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
		
	/**
	 * Encontra um client por zipcode
	 * @Param name
	 * @return ResponseEntity<Client>
	 */
    @RequestMapping(value = "/clients/zipcode/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> GetClientByZipCode(@PathVariable(value = "id") Long id)
    {    	
    	Optional<Client> client = clientServices.findClientByZipCode(id);
         
        if(client.isPresent())
            return new ResponseEntity<Client>(client.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
	/**
	 * Salvando um novo client no banco
	 * @Param name
	 * @return ResponseEntity<Client>
	 */
    @PostMapping("/clients")
    Client newClient(@RequestBody Client client) {
      return clientServices.saveClient(client);
    }
    
    
	/**
	 * Editar um client
	 * @param doc
	 * @return ResponseEntity<Client> */
    @RequestMapping(value = "/client/update/{doc}", method =  RequestMethod.PUT)
    public ResponseEntity<Client> putClient(@PathVariable(value = "doc") String doc, @RequestBody Client newClient)
    {
        Optional<Client> oldClient = clientServices.findByDoc(doc);
        
        if(oldClient.isPresent()){
        	clientServices.saveClient(newClient);     
        	return new ResponseEntity<Client>(newClient, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
    
  /**
   * Deletar um client
   * @param doc
   * @return void
   */
    @RequestMapping(value = "client/delete/{doc}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable(value = "doc") String doc)
    {
        Optional<Client> oldClient = clientServices.findByDoc(doc);
        
        if(oldClient.isPresent()){
        	clientServices.deleteClient(oldClient.get());
        	return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
    }
    }
    
}