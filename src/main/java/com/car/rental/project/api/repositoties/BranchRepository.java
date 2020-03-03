package com.car.rental.project.api.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.rental.project.api.entities.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

	Branch findBranchById(Long id);
}
