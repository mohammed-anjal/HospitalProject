package com.ty.hospitalapp.controller;

import com.ty.hospitalapp.dto.Hospital;
import com.ty.hospitalapp.service.HospitalService;

public class SaveHospital {
	public static void main(String[] args) {
		HospitalService hospitalService = new HospitalService();
		Hospital hospital = new Hospital();
		hospital.setName("Renai");
		hospital.setWebsite("www.renai.com");
		
	}
}
