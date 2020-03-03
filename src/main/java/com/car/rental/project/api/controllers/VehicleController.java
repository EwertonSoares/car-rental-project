package com.car.rental.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.project.api.entities.Vehicle;
import com.car.rental.project.api.services.VehicleServices;

@RestController
@CrossOrigin(origins = "*")
public class VehicleController {

	@Autowired
	private VehicleServices vehicleServices;
	
	/** 
	 * Retorna todos veiculos
	 * 
	 * @return List<Vehicle>
	 */
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public List<Vehicle> getVehicles() {
		return vehicleServices.findAllClients();
	}
}
