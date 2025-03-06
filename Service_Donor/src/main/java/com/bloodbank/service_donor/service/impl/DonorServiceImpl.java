package com.bloodbank.service_donor.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bloodbank.service_donor.domain.Donor;
import com.bloodbank.service_donor.domain.Transaction;
import com.bloodbank.service_donor.enums.ErrorMessageEnum;
import com.bloodbank.service_donor.exceptions.DonorNotFoundException;
import com.bloodbank.service_donor.exceptions.UsernameExistsException;
import com.bloodbank.service_donor.proxy.DonorProxy;
import com.bloodbank.service_donor.repository.DonorRepo;
import com.bloodbank.service_donor.service.DonorServices;
import com.bloodbank.service_donor.utils.MapperUtils;

@Service
public class DonorServiceImpl implements DonorServices{
	
	@Autowired
	private DonorRepo donorRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String saveDonor(DonorProxy donor) {
		if (!restTemplate.getForObject("http://localhost:8080/bank/is-user-name-available/" + donor.getUsername(), Boolean.class)) {
	        throw new UsernameExistsException(ErrorMessageEnum.USERNAME_EXISTS.getErrMessage(), ErrorMessageEnum.USERNAME_EXISTS.getErrCode());
		}
	        else {
	        	Donor d = MapperUtils.convertValue(donor, Donor.class);
	    		donorRepo.save(d);
	    		// TODO Auto-generated method stub
	    		return "Donor Saved Successfully.";
			}
	}

	@Override
	public DonorProxy getDonorByUsername(String username) {
		// TODO Auto-generated method stub
		Optional<Donor> op = donorRepo.findById(username);
		if(!op.isPresent()) {
			throw new DonorNotFoundException(ErrorMessageEnum.DONOR_NOT_FOUND.getErrMessage(),ErrorMessageEnum.DONOR_NOT_FOUND.getErrCode());
		} 
		return MapperUtils.convertValue(op.get(), DonorProxy.class);
	}

	@Override
	public String deleteDonorByUsername(String username) {
		// TODO Auto-generated method stub
		Optional<Donor> op = donorRepo.findById(username);
		if(!op.isPresent()) {
			throw new DonorNotFoundException(ErrorMessageEnum.DONOR_NOT_FOUND.getErrMessage(),ErrorMessageEnum.DONOR_NOT_FOUND.getErrCode());
		}
		donorRepo.deleteById(username);
		return "Donor Deleted Successfully.";
	}

	@Override
	public List<DonorProxy> getAllDonors() {
		// TODO Auto-generated method stub
		List<DonorProxy> donorList = MapperUtils.convertListValue(donorRepo.findAll(),DonorProxy.class);
		return donorList;
	}

	@Override
	public Transaction donateBlood(Transaction transaction) {
		// TODO Auto-generated method stub
		return transaction;
	}

	@Override
	public Boolean isUsernameAvailable(String username) {
		// TODO Auto-generated method stub
		return !donorRepo.existsById(username);
	}

	@Override
	public List<String> getAllBloodGroups() {
		// TODO Auto-generated method stub
		return null;
	}

}
