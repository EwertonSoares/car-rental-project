package com.car.rental.project.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "client")
public class Client implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6921839093511674493L;
	
	
	private String doc;
	private String name;
	private Long zipCode;
	private String address;
	private Long phoneNumber;
	private String perfil;
	private List<Vehicle> vehiclesRent;
	//@Enumerated(EnumType.STRING)
	//private PerfilEnum perfil;
	
	
	@Id
	@Column(name = "doc", nullable = false)
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "zip_code")
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "phone_number")
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name = "perfil")
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Vehicle> getVehiclesRent() {
		return vehiclesRent;
	}
	
	public void setVehiclesRent(List<Vehicle> vehiclesRent) {
		this.vehiclesRent = vehiclesRent;
	}

	@Override
	public String toString() {
		return "Client [ssnOrNrole=" + doc + ", name=" + name + ", zipCode=" + zipCode + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", perfil=" + perfil + ", vehiclesRent=" + vehiclesRent + "]";
	}
	
}