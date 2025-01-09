package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Observation;

public interface ObservationDao {
	Observation saveObservation (int eid, Observation observation);
	
	boolean deleteObservationById (int oid);
	
	Observation getObservationById(int oid);
	
	Observation updateObservationById (int oid, Observation observation);
	
	List<Observation> getAllObservation();
	
	List<Observation> getObservationByDoctorName(String name);
}
