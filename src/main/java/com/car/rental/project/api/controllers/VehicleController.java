package com.car.rental.project.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
		return vehicleServices.findAll();
	}
	
	/**
	 * Pergar um veiculo por id
	 * @param id
	 * Return Vehicle
	 */
	@RequestMapping(value = "/vehicles/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long id) {
		
		Optional<Vehicle> vehicle = vehicleServices.findById(id);
		
		if(vehicle.isPresent()) 
			return new ResponseEntity<Vehicle>(vehicle.get(), HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * Pergar um veiculo por id
	 * @param id
	 * Return Vehicle
	 */
	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	public Vehicle postVehicle(@Valid @RequestBody Vehicle newVehicle){
	
		return vehicleServices.saveVehicle(newVehicle);
	}

}
