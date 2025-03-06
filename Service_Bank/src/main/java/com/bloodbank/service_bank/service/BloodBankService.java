package com.bloodbank.service_bank.service;

import java.util.List;


import com.bloodbank.service_bank.domian.Transaction;
import com.bloodbank.service_bank.domian.proxy.BloodSampleProxy;
import com.bloodbank.service_bank.domian.proxy.TransactionProxy;
import com.bloodbank.service_bank.enums.BloodQuality;
import com.bloodbank.service_bank.enums.BloodType;
import com.bloodbank.service_bank.enums.TransactionType;

public interface BloodBankService {
	
	//donor and consumer
	public Boolean isUserNameAvailable(String userName);
	//donor
	public String donateBlood(Transaction transaction);
	//consumer
	public String requestBlood(Transaction transaction);
	//all can access
	public List<String> getAllBloodGroups();
	//admin
	public List<BloodSampleProxy> getAllBloodGroupSamples(BloodType bloodGroup);
	//admin
	public List<TransactionProxy> getAllBloodGroupTransactions(BloodType bloodGroup);
	// admin
	public List<TransactionProxy> getAllBloodGroupTransactionsAsPerType(BloodType bloodGroup, TransactionType type);
	// admin
	public List<BloodSampleProxy> getAllBloodGroupSamplesAsPerQuality(BloodType bloodGroup, BloodQuality quality);
	
	//admin
	public String addBloodGroup(BloodType newBloodGroup);
	
}
