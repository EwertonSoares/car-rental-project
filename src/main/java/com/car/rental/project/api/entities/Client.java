package com.car.rental.project.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.car.rental.project.api.enums.PerfilEnum;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6921839093511674493L;
	
	
	private String ssnOrNrole;
	private String name;
	private Long zipCode;
	private String address;
	private Long phoneNumber;
	private PerfilEnum perfil;
	private List<Vehicle> vehiclesRent;
	
	
	@Id
	@Column(name = "ssn_or_nrole", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getSsnOrNrole() {
		return ssnOrNrole;
	}
	public void setSsnOrNrole(String ssnOrNrole) {
		this.ssnOrNrole = ssnOrNrole;
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
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil")
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
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
		return "Client [ssnOrNrole=" + ssnOrNrole + ", name=" + name + ", zipCode=" + zipCode + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", perfil=" + perfil + ", vehiclesRent=" + vehiclesRent + "]";
	}
	
}
