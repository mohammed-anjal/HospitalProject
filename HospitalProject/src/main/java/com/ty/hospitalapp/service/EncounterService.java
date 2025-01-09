package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.EncounterDaoImp;
import com.ty.hospitalapp.dto.Encounter;

public class EncounterService {
	EncounterDaoImp daoImp = new EncounterDaoImp();

	public void saveEncounterService(Encounter encounter,int bid) {
		Encounter encounterRt = daoImp.saveEncounter(bid, encounter);
		if (encounterRt != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data was not saved !");
		}
	}

	public void deleteEncounterService(int eid) {
		boolean flag = daoImp.deleteEncounterById(eid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data was not deleted!");
		}
	}

	public Encounter getEncounterById(int eid) {
		Encounter encounter = daoImp.getEncounterById(eid);
		if (encounter != null) {
			return encounter;
		} else {
			return null;
		}
	}

	public void UpdateEncounterService(Encounter encounter,int eid) {
		Encounter encounterRt = daoImp.updateEncounterById(eid,encounter);
		if(encounterRt != null) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data was not updated !");
		}
}
	public List<Encounter> getAllEncounterService() {
		List<Encounter> encounters = daoImp.getAllEncounter();
		if (encounters != null) {
			return encounters;
		} else {
			return null;
		}
	}
}
