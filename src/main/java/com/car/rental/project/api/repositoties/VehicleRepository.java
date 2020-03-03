package com.car.rental.project.api.repositoties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.rental.project.api.entities.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	Vehicle findVehiclehById(Long id);
	
}
