package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Branch;

public interface BranchDao {
	Branch saveBranch(int hid, Branch branch);
	
	boolean deleteBranchById (int bid);
	
	Branch getBranchById(int bid);
	
	Branch updateBranchById(int bid, Branch branch);
	
	List<Branch> getAllBranch();
}
