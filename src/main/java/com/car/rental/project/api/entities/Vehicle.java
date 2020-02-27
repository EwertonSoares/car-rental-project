package com.car.rental.project.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.car.rental.project.api.enums.VehicleType;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4532843363490324779L;
	
	private Long id;
	private VehicleType vehicle;
	private Date loanDate;
	private Date returnDate;
	private float dailyValue;
	private float discount;
	private float totalValue;
	private float paidValue;
	private boolean disponivel;
	private Client client;
	private Branch branch;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "daily_value")
	public float getDailyValue() {
		return dailyValue;
	}
	public void setDailyValue(float dailyValue) {
		this.dailyValue = dailyValue;
	}
	
	@Column(name = "discount")
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	@Column(name = "total_value")
	public float getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}
	
	@Column(name = "paid_value")
	public float getPaidValue() {
		return paidValue;
	}
	public void setPaidValue(float paidValue) {
		this.paidValue = paidValue;
	}
	
	@Column(name = "loan_date")
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	
	@Column(name = "return_date")
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "vehicle")
	public VehicleType getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleType vehicle) {
		this.vehicle = vehicle;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	@OneToOne(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Branch getBranch() {
		return branch;
	}
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicle=" + vehicle + ", loanDate=" + loanDate + ", returnDate=" + returnDate
				+ ", dailyValue=" + dailyValue + ", discount=" + discount + ", totalValue=" + totalValue
				+ ", paidValue=" + paidValue + ", disponivel=" + disponivel + ", client=" + client + ", branch="
				+ branch + "]";
	}

}
