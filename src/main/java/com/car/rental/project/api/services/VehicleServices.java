package com.car.rental.project.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.car.rental.project.api.entities.Vehicle;
import com.car.rental.project.api.repositoties.VehicleRepository;

@Service
public class VehicleServices {

    private static final Logger LOGGER=LoggerFactory.getLogger(ClientServices.class);
    
    private VehicleRepository vehicleRepository;
    

	public List<Vehicle> findAllClients() {
		//LOGGER.info("Buscando lista com todos os veiculos");
		return vehicleRepository.findAll();
}

	public Vehicle saveVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

}
