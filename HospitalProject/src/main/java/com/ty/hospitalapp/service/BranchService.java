package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.BranchDaoImp;
import com.ty.hospitalapp.dto.Branch;

public class BranchService {
	BranchDaoImp daoImp = new BranchDaoImp();

	public void saveBranchService(Branch branch,int hid) {
		Branch branchRt = daoImp.saveBranch(hid, branch);
		if (branchRt != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data was not saved !");
		}
	}

	public void deleteBranchService(int bid) {
		boolean flag = daoImp.deleteBranchById(bid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data was not deleted!");
		}
	}

	public Branch getBranchById(int bid) {
		Branch branch = daoImp.getBranchById(bid);
		if (branch != null) {
			return branch;
		} else {
			return null;
		}
	}

	public void UpdateBranchService(Branch branch,int bid) {
		Branch branchRt = daoImp.updateBranchById(bid,branch);
		if(branchRt != null) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data was not updated !");
		}
}
	
	public List<Branch> getAllBranchService() {
		List<Branch> branches = daoImp.getAllBranch();
		if (branches != null) {
			return branches;
		} else {
			return null;
		}
	}
}
