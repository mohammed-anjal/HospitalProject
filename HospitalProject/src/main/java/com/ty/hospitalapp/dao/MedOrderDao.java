package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.MedOrder;

public interface MedOrderDao {
	MedOrder saveMedOrder (int eid, MedOrder medorder);
	
	boolean deleteMedOrderById(int mid);
	
	MedOrder getMedOrderById(int mid);
	
	MedOrder updateMedOrderById(int mid, MedOrder medOrder);
	
	List<MedOrder> getAllMedOrder();
	
	List<MedOrder> getMedOrderByDoctorName(String name);
}
