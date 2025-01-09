package com.ty.hospitalapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Observation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	private String dname;
	private String robservation;
	
	@ManyToOne
	@JoinColumn
	private Encounter encounters;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getRobservation() {
		return robservation;
	}

	public void setRobservation(String robservation) {
		this.robservation = robservation;
	}

	public Encounter getEncounters() {
		return encounters;
	}

	public void setEncounters(Encounter encounters) {
		this.encounters = encounters;
	}
	
	
}
