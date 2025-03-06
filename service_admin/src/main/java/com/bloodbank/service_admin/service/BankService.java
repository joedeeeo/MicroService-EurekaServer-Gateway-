package com.bloodbank.service_admin.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bloodbank.service_admin.enums.BloodType;
import com.bloodbank.service_admin.proxy.BloodSampleProxy;
import com.bloodbank.service_admin.proxy.TransactionProxy;

@FeignClient("SERVICE-BANK")
public interface BankService {

	
	@GetMapping("/bank/get-all-blood-groups")
	public List<String> getAllBloodGroups();
	
	@GetMapping("/bank/get-all-blood-group-samples/{bloodGroup}")
	public List<BloodSampleProxy> getAllBloodGroupSamples(@PathVariable("bloodGroup") BloodType bloodGroup);

	@GetMapping("/bank/get-all-blood-group-transactions/{bloodGroup}")
	public List<TransactionProxy> getAllBloodGroupTransactions(@PathVariable BloodType bloodGroup);
}
