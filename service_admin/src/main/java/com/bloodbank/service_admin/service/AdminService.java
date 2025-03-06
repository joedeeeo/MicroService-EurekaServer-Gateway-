package com.bloodbank.service_admin.service;

import java.util.List;

import com.bloodbank.service_admin.enums.BloodQuality;
import com.bloodbank.service_admin.enums.BloodType;
import com.bloodbank.service_admin.enums.TransactionType;
import com.bloodbank.service_admin.proxy.AdminProxy;
import com.bloodbank.service_admin.proxy.BloodSampleProxy;
import com.bloodbank.service_admin.proxy.TransactionProxy;

public interface AdminService {

	public String deleteUser(String username);

//	public String deleteBloodGroup(String bloodGroup);

	public List<AdminProxy> getAllAdmin();

	public AdminProxy getAdminByUsername(String username);

	public String deleteAdminByUsername(String username);

	public AdminProxy saveAdmin(AdminProxy adminProxy);

	// all can access
	public List<String> getAllBloodGroups();

	// admin
	public List<BloodSampleProxy> getAllBloodGroupSamples(BloodType bloodGroup);

	// admin
	public List<TransactionProxy> getAllBloodGroupTransactions(BloodType bloodGroup);

	// admin
	public List<TransactionProxy> getAllBloodGroupTransactionsAsPerType(BloodType bloodGroup, TransactionType type);

	// admin
	public List<BloodSampleProxy> getAllBloodGroupSamplesAsPerQuality(BloodType bloodGroup, BloodQuality quality);
	
	//admin
	public String addBloodSample(BloodType newBloodGroup);
}
