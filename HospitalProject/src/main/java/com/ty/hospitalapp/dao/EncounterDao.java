package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Encounter;

public interface EncounterDao {
	Encounter saveEncounter (int bid, Encounter encounter);
	
	boolean deleteEncounterById(int eid);
	
	Encounter getEncounterById (int eid);
	
	Encounter updateEncounterById (int eid, Encounter encounter);
	
	List<Encounter> getAllEncounter();
	
}
