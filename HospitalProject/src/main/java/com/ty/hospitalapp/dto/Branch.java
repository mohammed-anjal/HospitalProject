package com.ty.hospitalapp.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Branch {
	private int bid;
	private String name;
	private long phone;
	private String email;
	
	@ManyToOne
	@JoinColumn
	Hospital hospitals;
	
	@OneToOne
	@JoinColumn
	Address address;
	
	@OneToMany (mappedBy = "branches")
	private List<Encounter> encounters;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Hospital getHospitals() {
		return hospitals;
	}

	public void setHospitals(Hospital hospitals) {
		this.hospitals = hospitals;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	
	
}
