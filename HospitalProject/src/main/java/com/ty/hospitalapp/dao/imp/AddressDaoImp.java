package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.AddressDao;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Branch;

public class AddressDaoImp implements AddressDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Address saveAddress(int bid, Address address) {
		Branch branch = entityManager.find(Branch.class, bid);
		if (branch != null) {
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
			
			return address;
		}
		return null;
	}
	public boolean deleteAddressById(int aid) {
		Address address  = entityManager.find(Address.class, aid);
		if (address != null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			
			return true;
		}
		return false;
	}
	public Address getAddressById(int aid) {
		Address address  = entityManager.find(Address.class, aid);
		if (address != null) {
			return address;
		}
		return null;
	}
	public Address updateAddressById(int aid, Address address) {
		Address address1 = entityManager.find(Address.class, aid);
		if (address1 != null) {
			address1.setBranches(address.getBranches());
			address1.setCountry(address.getCountry());
			address1.setPin(address.getPin());
			address1.setState(address.getState());
			address1.setStreet(address.getStreet());
			
			entityTransaction.begin();
			entityManager.merge(address1);
		}
 		return null;
	}
	public List<Address> getAllAddress() {
		Query query = entityManager.createQuery("select s from Address s");
		List<Address> addresses = query.getResultList();
		return addresses;
	}
}
