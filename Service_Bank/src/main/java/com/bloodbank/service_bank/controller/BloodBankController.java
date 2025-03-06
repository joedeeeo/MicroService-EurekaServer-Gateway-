package com.bloodbank.service_bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.service_bank.domian.Transaction;
import com.bloodbank.service_bank.domian.proxy.BloodSampleProxy;
import com.bloodbank.service_bank.domian.proxy.TransactionProxy;
import com.bloodbank.service_bank.enums.BloodQuality;
import com.bloodbank.service_bank.enums.BloodType;
import com.bloodbank.service_bank.enums.TransactionType;
import com.bloodbank.service_bank.service.BloodBankService;

@RestController
@RequestMapping("/bank")
public class BloodBankController {
	
	@Autowired
	private BloodBankService service;
	
	@GetMapping("/is-user-name-available/{username}")
	public Boolean isUserNameAvailable(@PathVariable String username)
	{
		return service.isUserNameAvailable(username);
	}
	
	@PostMapping("/donate-blood")
	public String donateBlood(@RequestBody Transaction transaction)
	{
		return service.donateBlood(transaction);
	}
	
	@PostMapping("/request-blood")
	public String requestBlood(@RequestBody Transaction transaction)
	{
		return service.requestBlood(transaction);
	}
	
	@GetMapping("/get-all-blood-groups")
	public List<String> getAllBloodGroups()
	{
		return service.getAllBloodGroups();
	}
	
	@GetMapping("/get-all-blood-group-samples/{bloodGroup}")
	public List<BloodSampleProxy> getAllBloodGroupSamples(@PathVariable BloodType bloodGroup)
	{
		return service.getAllBloodGroupSamples(bloodGroup);
	}
	
	@GetMapping("/get-all-blood-group-transactions/{bloodGroup}")
	public List<TransactionProxy> getAllBloodGroupTransactions(@PathVariable BloodType bloodGroup)
	{
		return service.getAllBloodGroupTransactions(bloodGroup);
	}
	
	@GetMapping("/get-all-blood-group-transactions-asper-type/{bloodGroup}/{type}")
	public List<TransactionProxy> getAllBloodGroupTransactionsAsPerType(@PathVariable BloodType bloodGroup, @PathVariable TransactionType type)
	{
		return service.getAllBloodGroupTransactionsAsPerType(bloodGroup, type);
	}
	
	@GetMapping("/get-all-blood-group-samples-asper-quality/{bloodGroup}/{quality}")
	public List<BloodSampleProxy> getAllBloodGroupSamplesAsPerQuality(@PathVariable BloodType bloodGroup, @PathVariable BloodQuality quality)
	{
		return service.getAllBloodGroupSamplesAsPerQuality(bloodGroup, quality);
	}
	
	@PostMapping("/add-blood-group/{newBloodGroup}")
	public String addBloodGroup(@PathVariable BloodType newBloodGroup)
	{
		return service.addBloodGroup(newBloodGroup);
	}
	
}
