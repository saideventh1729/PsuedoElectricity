package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "electricity")

public class ElectricityBill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long electId;

	@Column(name = "amount")
	private double amount;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private LocalDate billdate;

	public ElectricityBill(double amount, String description, LocalDate billdate) {
		super();
		this.amount = amount;
		this.description = description;
		this.billdate = billdate;
	}

	public ElectricityBill() {
		super();
	}

	public long getElectId() {
		return electId;
	}

	public void setElectId(long electId) {
		this.electId = electId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getBilldate() {
		return billdate;
	}

	public void setBilldate(LocalDate billdate) {
		this.billdate = billdate;
	}

}
