package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.BranchDao;
import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.dto.Hospital;

public class BranchDaoImp implements BranchDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public Branch saveBranch(int hid, Branch branch) {
		Hospital hospital = entityManager.find(Hospital.class, hid);
		if (hospital != null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		}
		return null;
	}
	public boolean deleteBranchById(int bid) {
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	public Branch getBranchById(int bid) {
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
			return branch;
		}
		return null;
	}
	public Branch updateBranchById(int bid, Branch branch) {
		Branch branch1 = entityManager.find(Branch.class, bid);
		if (branch1 != null) {
			branch1.setName(branch.getName());
			branch1.setEmail(branch.getEmail());
			branch1.setPhone(branch.getPhone());
			
			branch1.setHospitals(branch.getHospitals());
			branch1.setAddress(branch.getAddress());
			branch1.setEncounters(branch.getEncounters());
			
			entityTransaction.begin();
			entityManager.merge(branch1);
			entityTransaction.commit();
			
			return branch1;			
		} else {
			return null;
		}
	}
	public List<Branch> getAllBranch() {
		Query query = entityManager.createQuery("select s from Branch s");
		List<Branch> branches = query.getResultList();		
		return branches;
	}
	
}
