package com.car.rental.project.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.rental.project.api.entities.Client;
import com.car.rental.project.api.repositoties.ClientRepository;

@Service
public class ClientServices {

    private static final Logger LOGGER=LoggerFactory.getLogger(ClientServices.class);
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public 	List<Client> findAll(){
		LOGGER.info("Buscando todos os clients");
		return clientRepository.findAll();
	}

	public 	Optional<Client>  findByDoc(String doc) {
		LOGGER.info("Buscando client por CPF ou CNPJ");
		return Optional.ofNullable(clientRepository.findByDoc(doc));
	}
		
	public Optional<Client> findClientByZipCode(Long zipCode) {
		LOGGER.info("Buscando client por CEP");
		return Optional.ofNullable(clientRepository.findClientByZipCode(zipCode));
	}

	public 	Client saveClient(Client client) {
		LOGGER.info("Salvando novo client");
		return clientRepository.save(client);
	}

	public void deleteClient(Client client) {
		LOGGER.info("Deletando client por CEP");
		clientRepository.delete(client);
	}
}