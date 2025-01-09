package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Address;

public interface AddressDao {
	Address saveAddress(int bid, Address address);
	
	boolean deleteAddressById(int aid);
	
	Address getAddressById(int aid);
	
	Address updateAddressById(int aid, Address address);
	
	List<Address> getAllAddress();
	
}
