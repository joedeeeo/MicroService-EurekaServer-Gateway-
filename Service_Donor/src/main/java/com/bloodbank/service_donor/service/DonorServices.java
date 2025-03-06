package com.bloodbank.service_donor.service;

import java.util.List;

import com.bloodbank.service_donor.domain.Transaction;
import com.bloodbank.service_donor.proxy.DonorProxy;

public interface DonorServices {
public String saveDonor(DonorProxy donor);
	
	public DonorProxy getDonorByUsername(String username);
	
	public String deleteDonorByUsername(String username);
	
	public List<DonorProxy> getAllDonors();
	
	public Transaction donateBlood(Transaction transaction);
	
	public Boolean isUsernameAvailable(String username);
	
	public List<String> getAllBloodGroups();
}
