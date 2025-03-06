package com.bloodbank.service_admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.service_admin.enums.BloodQuality;
import com.bloodbank.service_admin.enums.BloodType;
import com.bloodbank.service_admin.enums.TransactionType;
import com.bloodbank.service_admin.proxy.AdminProxy;
import com.bloodbank.service_admin.proxy.BloodSampleProxy;
import com.bloodbank.service_admin.proxy.TransactionProxy;
import com.bloodbank.service_admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;
	
	@DeleteMapping("/deleteUser/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {
		return new ResponseEntity<String>(service.deleteUser(username), HttpStatus.OK);
	}

//	@GetMapping("/deleteBloodGroup/{bloodGroup}")
//	public ResponseEntity<String> deleteBloodGroup(@PathVariable String bloodGroup) {
//		return new ResponseEntity<String>(service.deleteBloodGroup(bloodGroup), HttpStatus.OK);
//	}
	
	@PostMapping("/register")
	public ResponseEntity<AdminProxy> registerAdmin(@RequestBody AdminProxy adminProxy){
		return new ResponseEntity<AdminProxy>(service.saveAdmin(adminProxy), HttpStatus.CREATED);
	}

	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<AdminProxy>> getAllAdmin() {
		return new ResponseEntity<List<AdminProxy>>(service.getAllAdmin(), HttpStatus.OK);
	}

	@GetMapping("getAdmin/{username}")
	public ResponseEntity<AdminProxy> getAdmin(@PathVariable("username") String username) {
		return new ResponseEntity<AdminProxy>(service.getAdminByUsername(username), HttpStatus.OK);
	}

	@GetMapping("/deleteAdmin/{username}")
	public ResponseEntity<String> deleteAdmin(@PathVariable String username) {
		return new ResponseEntity<String>(service.deleteAdminByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping("/getAllBloodGroups")
	public ResponseEntity<List<String>> getAllBloodGroups(){
		return new ResponseEntity<List<String>>(service.getAllBloodGroups(),HttpStatus.OK);
	}
	
	@GetMapping("/get-all-blood-group-samples/{bloodGroup}")
	public ResponseEntity<List<BloodSampleProxy>> getAllBloodGroupSamples(@PathVariable("bloodGroup") BloodType bloodGroup)
	{
		return new ResponseEntity<List<BloodSampleProxy>>(service.getAllBloodGroupSamples(bloodGroup), HttpStatus.OK);
	}
	
	@GetMapping("/get-all-blood-group-transactions/{bloodGroup}")
	public ResponseEntity<List<TransactionProxy>> getAllBloodGroupTransactions(@PathVariable("bloodGroup") BloodType bloodGroup)
	{
		return new ResponseEntity<List<TransactionProxy>>(service.getAllBloodGroupTransactions(bloodGroup), HttpStatus.OK);
	}
	
	@GetMapping("/get-all-blood-group-transactions-asper-type/{bloodGroup}/{type}")
	public ResponseEntity<List<TransactionProxy>> getAllBloodGroupTransactionsAsPerType(@PathVariable BloodType bloodGroup, @PathVariable TransactionType type)
	{
		return new ResponseEntity<List<TransactionProxy>>(service.getAllBloodGroupTransactionsAsPerType(bloodGroup, type), HttpStatus.OK);
	}
	
	@GetMapping("/get-all-blood-group-samples-asper-quality/{bloodGroup}/{quality}")
	public ResponseEntity<List<BloodSampleProxy>> getAllBloodGroupSamplesAsPerQuality(@PathVariable BloodType bloodGroup, @PathVariable BloodQuality quality)
	{
		return new ResponseEntity<List<BloodSampleProxy>>(service.getAllBloodGroupSamplesAsPerQuality(bloodGroup, quality), HttpStatus.OK);
	}
	
	@PostMapping("/add-blood-group/{newBloodGroup}")
	public ResponseEntity<String> addBloodGroup(@PathVariable BloodType newBloodGroup)
	{
		return new ResponseEntity<String>(service.addBloodSample(newBloodGroup), HttpStatus.CREATED);
	}
	
//	@GetMapping("/deleteBloodGroup/{bloodGroup}")
//	public ResponseEntity<String> deleteBloodGroup(@PathVariable BloodType bloodGroup) {
//		return new ResponseEntity<String>(service.deleteBloodGroup(bloodGroup), HttpStatus.OK);
//	}
}
