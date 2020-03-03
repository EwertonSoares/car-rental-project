package com.car.rental.project.api.repositoties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//@NamedQuery(name = "MenuRepository.findByRestaurantId", 
//query = "SELECT * FROM menu m WHERE m.restaurant_id = :id")
//})

import com.car.rental.project.api.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
		
	Client findClientByZipCode(Long zipCode);
		
	@Query
	Client findByDoc(@Param(value = "doc") String doc);
	
}