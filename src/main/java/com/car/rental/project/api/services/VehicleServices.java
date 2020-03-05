package com.car.rental.project.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.rental.project.api.entities.Client;
import com.car.rental.project.api.entities.Vehicle;
import com.car.rental.project.api.repositoties.VehicleRepository;

@Service
public class VehicleServices {

    private static final Logger LOGGER=LoggerFactory.getLogger(ClientServices.class);
    
    @Autowired
    private VehicleRepository vehicleRepository;
    

	public List<Vehicle> findAll() {
		LOGGER.info("Buscando lista com todos os veiculos");
		return vehicleRepository.findAll();
}
	
	public Optional<Vehicle> findById(Long id) {
		LOGGER.info("Buscando veiculo por id");
		return vehicleRepository.findById(id);
	}
	

	public Vehicle saveVehicle(Vehicle vehicle) {
		LOGGER.info("Salvando Novo veiculo no banco");
		return vehicleRepository.save(vehicle);
	}


}
