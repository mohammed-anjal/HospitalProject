package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.ObservationDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.Observation;

public class ObservationDaoImp implements ObservationDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Observation saveObservation(int eid, Observation observation) {
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			
			return observation;
		}
		return null;
	}
	public boolean deleteObservationById(int oid) {
		Observation observation = entityManager.find(Observation.class, oid);
		if (observation != null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			
			return true;
		}
		return false;
	}
	public Observation getObservationById(int oid) {
		Observation observation = entityManager.find(Observation.class, oid);
		if (observation != null) {
			return observation;
		}
		return null;
	}
	public Observation updateObservationById(int oid, Observation observation) {
		Observation observation1 = entityManager.find(Observation.class, oid);
		if (observation1 != null) {
			observation1.setDname(observation.getDname());
			observation1.setEncounters(observation.getEncounters());
			observation1.setRobservation(observation.getRobservation());
			
			entityTransaction.begin();
			entityManager.merge(observation1);
			entityTransaction.commit();
			
			return observation1;			
		}
		return null;
	}
	public List<Observation> getAllObservation() {
		Query query = entityManager.createQuery("select s from Encounter s");
		List<Observation> observations = query.getResultList();
		return observations;
	}
	public List<Observation> getObservationByDoctorName(String name) {
		Query query = entityManager.createQuery("SELECT o.dname FROM Observation o WHERE o.dname =?");
		query.setParameter(1, name);
		List <Observation> observations = query.getResultList();
		return observations;
	}
	
	
}
