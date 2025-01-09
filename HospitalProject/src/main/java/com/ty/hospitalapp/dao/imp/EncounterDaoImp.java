package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.EncounterDao;
import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.dto.Encounter;

public class EncounterDaoImp implements EncounterDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Encounter saveEncounter(int bid, Encounter encounter) {
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
			return encounter;
		}
		return null;
	}

	public boolean deleteEncounterById(int eid) {
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Encounter getEncounterById(int eid) {
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			return encounter;
		}
		return null;
	}

	public Encounter updateEncounterById(int eid, Encounter encounter) {
		Encounter encounter1 = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			encounter1.setBranches(encounter.getBranches());
			encounter1.setDateOfJoin(encounter.getDateOfJoin());
			encounter1.setDischarge(encounter.getDischarge());
			encounter1.setMedorders(encounter1.getMedorders());
			encounter1.setObservations(encounter.getObservations());
			encounter1.setPerson(encounter.getPerson());
			encounter1.setReason(encounter.getReason());
			
			entityTransaction.begin();
			entityManager.merge(encounter1);
			entityTransaction.commit();
			
			return encounter1;
		}
		return null;
	}

	public List<Encounter> getAllEncounter() {
		Query query = entityManager.createQuery("select s from Encounter s");
		List <Encounter> encounters = query.getResultList();
		
		return encounters;
	}
	
}
