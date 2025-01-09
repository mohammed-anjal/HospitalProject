package com.ty.hospitalapp.service;

import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dto.Hospital;

public class HospitalService {
	
	public void saveHospitalService (Hospital hospital) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		daoImp.saveHospital(hospital);
		if (hospital != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data Not Saved");
		}
	}
	
	public Hospital getHospitalByIdService (int hid) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital = daoImp.getHospitalById(hid);
		if (hospital != null) {
			return hospital;
		} else {
			return null;
		}
	}
	
	
	public void deleteHospitalByIdService(int hid) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		boolean flag = daoImp.deleteHospitalById(hid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data Not Deleted");
		}
	}
	
	public Hospital updateHospitalByIdService(int hid, Hospital hospital) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital2 = daoImp.getHospitalById(hid);
		if(hospital2 != null) {
			return hospital2;		
		} else {
			return null;
		}
	}
	
}
