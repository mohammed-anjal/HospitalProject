package com.ty.hospitalapp.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospitalapp.dao.HospitalDao;
import com.ty.hospitalapp.dto.Hospital;

public class HospitalDaoImp implements HospitalDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Hospital saveHospital(Hospital hospital) {
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		return hospital;
	}
	public Hospital getHospitalById(int hid) {
		Hospital hospital = entityManager.find(Hospital.class, hid);
		if (hospital != null) {
			return hospital;
		}
		return null;
	}
	public boolean deleteHospitalById(int hid) {
		Hospital hospital = entityManager.find(Hospital.class, hid);
		if (hospital != null) {
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	public Hospital updateHospitalById(int hid, Hospital hospital) {
		Hospital hospital1 = entityManager.find(Hospital.class, hid);
		if (hospital1 != null) {
			hospital1.setName(hospital.getName());
			hospital1.setWebsite(hospital.getWebsite());
			hospital1.setBranches(hospital.getBranches());
			entityTransaction.begin();
			entityManager.merge(hospital1);
			entityTransaction.commit();
			return hospital1;
		}
		return null;
	}
}
