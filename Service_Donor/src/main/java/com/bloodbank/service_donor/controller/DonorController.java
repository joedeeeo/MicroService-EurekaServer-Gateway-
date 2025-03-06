package com.bloodbank.service_donor.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.service_donor.domain.Transaction;
import com.bloodbank.service_donor.proxy.DonorProxy;
import com.bloodbank.service_donor.service.DonorServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/donor")
public class DonorController {
	@Autowired
	private DonorServices donorService;
	
	@PostMapping("/saveDonor")
	public String saveDonor(@Valid @RequestBody DonorProxy donor) {
		return donorService.saveDonor(donor);
	}
	
	@GetMapping("/getDonorByUsername/{uname}")
	public DonorProxy getDonorByUsername(@PathVariable("uname") String uname) {
		return donorService.getDonorByUsername(uname);
	}
	
	@GetMapping("/getAllDonors")
	public List<DonorProxy> getAllDonors() {
		return donorService.getAllDonors();
	} 
	
	@DeleteMapping("/deleteDonorByUsername/{uname}")
	public String deleteDonorByUsername(@PathVariable("uname") String uname) {
		return donorService.deleteDonorByUsername(uname);
	}
	
	@PostMapping("/donateBlood")
	public Transaction donateBlood(@RequestBody Transaction transaction) {
		 transaction.setTransactionId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
		return donorService.donateBlood(transaction);
	}
	
	@GetMapping("/isDonorUsernameAvailable/{username}")
	public Boolean isDonorUsernameAvailable(@PathVariable("username") String username) {
		System.out.println(donorService.isUsernameAvailable(username));
		return donorService.isUsernameAvailable(username);
	}
}
