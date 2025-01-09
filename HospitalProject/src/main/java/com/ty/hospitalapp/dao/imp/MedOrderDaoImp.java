package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.MedOrderDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.MedOrder;

public class MedOrderDaoImp implements MedOrderDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();


	public MedOrder saveMedOrder(int eid, MedOrder medorder) {
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.persist(medorder);
			entityTransaction.commit();
			
			return medorder;
		}
		return null;
	}

	public boolean deleteMedOrderById(int mid) {
		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		if (medOrder != null) {
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			
			return true;
		}
		return false;
	}

	public MedOrder getMedOrderById(int mid) {
		MedOrder medOrder = entityManager.find(MedOrder.class, mid);
		if (medOrder != null) {
			return medOrder;
		}
		return null;
	}

	public MedOrder updateMedOrderById(int mid, MedOrder medOrder) {
		MedOrder medOrder1 = entityManager.find(MedOrder.class , mid);
		if (medOrder1 != null) {
			medOrder1.setDname(medOrder.getDname());
			medOrder1.setEncounters(medOrder.getEncounters());
			medOrder1.setItems(medOrder.getItems());
			medOrder1.setOrderDate(medOrder.getOrderDate());
			
			entityTransaction.begin();
			entityManager.merge(medOrder1);
			entityTransaction.commit();
			
			return medOrder1;
		}
		return null;
	}

	public List<MedOrder> getAllMedOrder() {
		Query query = entityManager.createQuery("select s from MedOrder s");
		List<MedOrder> medOrders = query.getResultList();
		return medOrders;
	}

	public List<MedOrder> getMedOrderByDoctorName(String name) {
		Query query = entityManager.createQuery("SELECT o.dname FROM MedOrder o WHERE o.dname =?");
		query.setParameter(1, name);
		List <MedOrder> medOrders = query.getResultList();
		return medOrders;
	}
	

}
