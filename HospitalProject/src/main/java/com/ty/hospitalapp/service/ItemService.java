package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.ItemDaoImp;
import com.ty.hospitalapp.dto.Item;

public class ItemService {
	ItemDaoImp daoImp = new ItemDaoImp();

	public void saveItemService(Item item,int mid) {
		Item itemRt = daoImp.saveItem(mid,item);
		if (itemRt != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data was not saved !");
		}
	}

	public void deleteItemService(int iid) {
		boolean flag = daoImp.deleteItemById(iid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data was not deleted!");
		}
	}

	public Item getItemById(int iid) {
		Item item = daoImp.getItemById(iid);
		if (item != null) {
			return item;
		} else {
			return null;
		}
	}

	public void UpdateItemService(Item item,int iid) {
		Item itemRt = daoImp.updateItemById(iid,item);
		if(itemRt != null) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data was not updated !");
		}
}
	public List<Item> getAllItemService() {
		List<Item> items = daoImp.getAllItem();
		if (items != null) {
			return items;
		} else {
			return null;
		}
	}
}
