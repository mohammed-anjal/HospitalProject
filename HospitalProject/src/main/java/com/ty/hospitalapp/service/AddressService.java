package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.AddressDaoImp;
import com.ty.hospitalapp.dto.Address;

public class AddressService {
	AddressDaoImp daoImp = new AddressDaoImp();

	public void saveAddressService(Address address,int bid) {
		Address addressRt = daoImp.saveAddress(bid, address);
		if (addressRt != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data was not saved !");
		}
	}

	public void deleteAddressService(int aid) {
		boolean flag = daoImp.deleteAddressById(aid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data was not deleted!");
		}
	}

	public Address getAddressById(int aid) {
		Address address = daoImp.getAddressById(aid);
		if (address != null) {
			return address;
		} else {
			return null;
		}
	}

	public void UpdateAddressService(Address address,int aid) {
		Address addressRt = daoImp.updateAddressById(aid,address);
		if(addressRt != null) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data was not updated !");
		}
}
	public List<Address> getAllAddressService() {
		List<Address> addresses = daoImp.getAllAddress();
		if (addresses != null) {
			return addresses;
		} else {
			return null;
		}
	}
}
