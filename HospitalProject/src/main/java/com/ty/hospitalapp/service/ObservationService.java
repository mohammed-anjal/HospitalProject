package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.ObservationDaoImp;
import com.ty.hospitalapp.dto.Observation;

public class ObservationService {
	ObservationDaoImp daoImp = new ObservationDaoImp();

	public void saveObservationService(Observation observation,int eid) {
		Observation observationRt = daoImp.saveObservation(eid, observation);
		if (observationRt != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data was not saved !");
		}
	}

	public void deleteObservationService(int oid) {
		boolean flag = daoImp.deleteObservationById(oid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data was not deleted!");
		}
	}

	public Observation getObservationById(int oid) {
		Observation observation = daoImp.getObservationById(oid);
		if (observation != null) {
			return observation;
		} else {
			return null;
		}
	}

	public void UpdateObservationService(Observation observation,int oid) {
		Observation observationRt = daoImp.updateObservationById(oid,observation);
		if(observationRt != null) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data was not updated !");
		}
}
	public List<Observation> getAllObservationService() {
		List<Observation> observations = daoImp.getAllObservation();
		if (observations != null) {
			return observations;
		} else {
			return null;
		}
	}
}
