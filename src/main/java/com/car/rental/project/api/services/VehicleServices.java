package com.car.rental.project.api.services;

import java.util.List;

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
	
	public Vehicle saveVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

}
