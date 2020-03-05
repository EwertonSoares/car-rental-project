package com.car.rental.project.api.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "vehicle" })
@Entity
@Table(name = "branch")
public class Branch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1616947170465128968L;
	
	
	private Long id;
	private String nome;
	private String address;
	private Vehicle vehicle;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@OneToOne(mappedBy = "branch", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return "Branch [id=" + id + ", nome=" + nome + ", address=" + address + ", vehicle="
				+ vehicle + "]";
	}
	
}
