package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.ItemDao;
import com.ty.hospitalapp.dto.Item;
import com.ty.hospitalapp.dto.MedOrder;

public class ItemDaoImp implements ItemDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Item saveItem(int mid, Item item) {
		MedOrder medOrder = entityManager.find(MedOrder.class , mid);
		if (medOrder != null) {
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.begin();
			
			return item;
		}
		return null;
	}

	public boolean deleteItemById(int iid) {
		Item item = entityManager.find(Item.class, iid);
		if (item != null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			
			return true;
		}
		return false;
	}

	public Item getItemById(int iid) {
		Item item = entityManager.find(Item.class, iid);
		if (item != null) {
			return item;
		}
		return null;
	}

	public Item updateItemById(int iid, Item item) {
		Item item1 = entityManager.find(Item.class, iid);
		if (item1 != null) {
			item1.setCost(item.getCost());
			item1.setItemName(item.getItemName());
			item1.setMedorders(item.getMedorders());
			item1.setQuantity(item.getQuantity());
			
			entityTransaction.begin();
			entityManager.merge(item1);
			entityTransaction.commit();
			
			return item1;
		}
		return null;
	}

	public List<Item> getAllItem() {
		Query query = entityManager.createQuery("select s from Item s");
		List <Item> items = query.getResultList();
		
		return items;
	}
	
}
