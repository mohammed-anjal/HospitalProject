package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.MedOrderDaoImp;
import com.ty.hospitalapp.dto.MedOrder;

public class MedOrderService {
	MedOrderDaoImp daoImp = new MedOrderDaoImp();

	public void saveMedOrderService(MedOrder medOrder,int eid) {
		MedOrder medOrderRt = daoImp.saveMedOrder(eid, medOrder);
		if (medOrderRt != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data was not saved !");
		}
	}

	public void deleteMedOrderService(int mid) {
		boolean flag = daoImp.deleteMedOrderById(mid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data was not deleted!");
		}
	}

	public MedOrder getMedOrderById(int mid) {
		MedOrder medOrder = daoImp.getMedOrderById(mid);
		if (medOrder != null) {
			return medOrder;
		} else {
			return null;
		}
	}

	public void UpdateMedOrderService(MedOrder medOrder,int mid) {
		MedOrder medOrderRt = daoImp.updateMedOrderById(mid,medOrder);
		if(medOrderRt != null) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data was not updated !");
		}
}
	public List<MedOrder> getAllMedOrderService() {
		List<MedOrder> medOrders = daoImp.getAllMedOrder();
		if (medOrders != null) {
			return medOrders;
		} else {
			return null;
		}
	}
}
