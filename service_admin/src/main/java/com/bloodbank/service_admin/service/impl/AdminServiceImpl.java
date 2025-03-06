package com.bloodbank.service_admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bloodbank.service_admin.domain.Admin;
import com.bloodbank.service_admin.enums.BloodQuality;
import com.bloodbank.service_admin.enums.BloodType;
import com.bloodbank.service_admin.enums.TransactionType;
import com.bloodbank.service_admin.proxy.AdminProxy;
import com.bloodbank.service_admin.proxy.BloodSampleProxy;
import com.bloodbank.service_admin.proxy.TransactionProxy;
import com.bloodbank.service_admin.repo.AdminRepo;
import com.bloodbank.service_admin.service.AdminService;
import com.bloodbank.service_admin.service.BankService;
import com.bloodbank.service_admin.utils.MapperUtil;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private BankService bankService;
	
	@Override
	public String deleteUser(String username) {
		// TODO Auto-generated method stub
	   restTemplate.delete("http://localhost:8082/consumer/deleteConsumerByUsername/{username}", username);
	   return "user deleted by admin";
	}

//	@Override
//	public String deleteBloodGroup(String bloodGroup) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

	@Override
	public List<AdminProxy> getAllAdmin() {
		List<Admin> adminList = repo.findAll();
		return MapperUtil.convertListOfValue(adminList, AdminProxy.class);

	}

	@Override
	public AdminProxy getAdminByUsername(String username) {
		Admin admin = repo.findByUsername(username).orElseThrow(() -> new RuntimeException("Username Not Found Based on given Input"));
		return MapperUtil.convertValue(admin, AdminProxy.class);

	}

	@Override
	public String deleteAdminByUsername(String username) {
		repo.deleteByUsername(username);
		return "Admin has been deleted with username : " + username;
	}

	@Override
	public AdminProxy saveAdmin(AdminProxy adminProxy) {
		Admin admin = MapperUtil.convertValue(adminProxy, Admin.class);
		Admin savedAdmin = repo.save(admin);
		adminProxy.setId(savedAdmin.getId());
		return adminProxy;
	}

	@Override
	public List<String> getAllBloodGroups() {
		// TODO Auto-generated method stub
//		String[] respStrings = restTemplate.getForObject("http://localhost:8080/bank/get-all-blood-groups", String[].class);
//		return List.of(respStrings);
		return bankService.getAllBloodGroups();

	}

	@Override
	public List<BloodSampleProxy> getAllBloodGroupSamples(BloodType bloodGroup) {
//		List<BloodSampleProxy> resp = restTemplate.getForObject("http://localhost:8080/bank/get-all-blood-group-samples/"+ bloodGroup.toString(), ArrayList.class);
//		return resp;
		return bankService.getAllBloodGroupSamples(bloodGroup);
		
	}
 
	@Override
	public List<TransactionProxy> getAllBloodGroupTransactions(BloodType bloodGroup) {
//		List<TransactionProxy> resp = restTemplate.getForObject("http://localhost:8080/bank/get-all-blood-group-transactions/"+bloodGroup.toString(), ArrayList.class);
//		return resp;
		return bankService.getAllBloodGroupTransactions(bloodGroup);

	}
 
	@Override
	public List<TransactionProxy> getAllBloodGroupTransactionsAsPerType(BloodType bloodGroup, TransactionType type) {
		List<TransactionProxy> resp = restTemplate.getForObject("http://localhost:8080/bank/get-all-blood-group-transactions-asper-type/"+bloodGroup.toString() +"/"+ type.toString(), ArrayList.class);
		return resp;
	}
 
	@Override
	public List<BloodSampleProxy> getAllBloodGroupSamplesAsPerQuality(BloodType bloodGroup, BloodQuality quality) {
		List<BloodSampleProxy> resp = restTemplate.getForObject("http://localhost:8080/bank/get-all-blood-group-samples-asper-quality/"+ bloodGroup.toString() + "/"+ quality.toString(), ArrayList.class);
		return resp;
	}
 
	@Override
	public String addBloodSample(BloodType newBloodGroup) {
		String resp = restTemplate.postForObject("http://localhost:8080/bank/add-blood-group/"+newBloodGroup.toString(), newBloodGroup ,String.class);
		System.out.println("Inside the Admin Service.");
		return resp;
	}

//	@Override
//	public String deleteBloodGroup(String bloodGroup) {
//		// TODO Auto-generated method stub
//		restTemplate.getForObject("http://localhost:8080/bank/deleteBloodGroup/"+ bloodGroup.toString(), String.class);
//		 return "blood group deleted by admin";
//	}
	
	

}
