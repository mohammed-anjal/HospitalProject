package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Item;

public interface ItemDao {
	Item saveItem(int mid, Item item);
	
	boolean deleteItemById(int iid);
	
	Item getItemById(int iid);
	
	Item updateItemById(int iid, Item item);
	
	List<Item> getAllItem();
}
