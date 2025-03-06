package com.bloodbank.service_bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bloodbank.service_bank.domian.BloodGroup;
import com.bloodbank.service_bank.domian.BloodSample;
import com.bloodbank.service_bank.domian.Transaction;
import com.bloodbank.service_bank.domian.proxy.BloodSampleProxy;
import com.bloodbank.service_bank.domian.proxy.TransactionProxy;
import com.bloodbank.service_bank.enums.BloodQuality;
import com.bloodbank.service_bank.enums.BloodType;
import com.bloodbank.service_bank.enums.TransactionType;
import com.bloodbank.service_bank.repository.BloodBankRepository;
import com.bloodbank.service_bank.service.BloodBankService;
import com.bloodbank.service_bank.utils.Mapper;

@Service
public class BloodBankServiceImpl implements BloodBankService {

	@Autowired
	private Mapper mapper;

	@Autowired
	private BloodBankRepository db;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Boolean isUserNameAvailable(String username) {
		
	 	return restTemplate.getForObject("http://localhost:8082/consumer/isConsumerUsernameAvailable/"+username, Boolean.class) &&
	 			restTemplate.getForObject("http://localhost:8081/donor/isDonorUsernameAvailable/"+username, Boolean.class);
		
	}
	
//	@Override
//	public Boolean isUserNameAvailable(String username) {
//	    Boolean isConsumerAvailable = null;
//	    Boolean isDonorAvailable = null;
//
//	    try {
//	        // Check if username is available in the consumer service
//	        isConsumerAvailable = restTemplate.getForObject(
//	            "http://localhost:8082/consumer/isConsumerUsernameAvailable/" + username,
//	            Boolean.class
//	        );
//
//	        // Check if username is available in the donor service
//	        isDonorAvailable = restTemplate.getForObject(
//	            "http://localhost:8081/donor/isDonorUsernameAvailable/" + username,
//	            Boolean.class
//	        );
//	        
//	        // Ensure both responses are not null and combine them
//	        if (isConsumerAvailable != null && isDonorAvailable != null) {
//	            return isConsumerAvailable && isDonorAvailable;
//	        } else {
//	            // Handle the case where either response is null
//	            return false;
//	        }
//	    } catch (Exception e) {
//	        // Log or handle exception appropriately
//	        e.printStackTrace();  // Replace with a logger in production code
//	        return false;  // Return false if an exception occurs
//	    }
//	}


	@Override
	public String donateBlood(Transaction transaction) {

		if (!db.existsById(transaction.getGroup()))
			return "No such blood group exist in bank";

		// add transaction
		BloodGroup entity = db.findById(transaction.getGroup()).get();

		if (entity.getTransactions() == null) {
			entity.setTransactions(new ArrayList<Transaction>());
		}

		entity.getTransactions().add(transaction);
		entity = db.save(entity);

		Long uniqueId = entity.getTransactions().get(entity.getTransactions().size() - 1).getUniqueId();

		// add sample
		BloodSample newSample = new BloodSample();
		newSample.setDonerName(transaction.getUserName());
		newSample.setQuality(transaction.getQuality());
		newSample.setUniqueTransactionId(uniqueId);
		newSample.setUnitsAvailable(transaction.getUnits());
		entity.getAvailableSamples().add(newSample);
		db.save(entity);

		return "Donation Successful, your reference id is :- " + uniqueId;
	}

	@Override
	public String requestBlood(Transaction transaction) {
		if (!db.existsById(transaction.getGroup()))
			return "No such blood group exist in bank";

		BloodGroup entity = db.findById(transaction.getGroup()).get();
		if (entity.getAvailableSamples() == null) {
			entity.setAvailableSamples(new ArrayList<BloodSample>());
		}

		// check samples and provide to consumer
		for (BloodSample sample : entity.getAvailableSamples()) {
			if (sample.getUnitsAvailable() >= transaction.getUnits()
					&& sample.getQuality() == transaction.getQuality()) {
				// deduct blood from sample
				sample.setUnitsAvailable(sample.getUnitsAvailable() - transaction.getUnits());
				db.save(entity);

				// add transaction
				if (entity.getTransactions() == null) {
					entity.setTransactions(new ArrayList<Transaction>());
				}
				entity.getTransactions().add(transaction);
				entity = db.save(entity);
				Long uniqueId = entity.getTransactions().get(entity.getTransactions().size() - 1).getUniqueId();

				return "Request Accepted, your reference id is :- " + uniqueId
						+ " show this at time of collection. Your donor name is " + sample.getDonerName();
			}
		}

		return "Sorry the requested blood with provided parameters is not available";
	}

	@Override
	public List<String> getAllBloodGroups() {
		List<String> availableBloodGroups = new ArrayList<>();
		for (BloodGroup group : db.findAll()) {
			availableBloodGroups.add(group.getType().toString());
		}
		return availableBloodGroups;
	}

	@Override
	public List<BloodSampleProxy> getAllBloodGroupSamples(BloodType bloodGroup) {

		if (!db.existsById(bloodGroup))
			throw new RuntimeException("No such blood group exist in bank");

		List<BloodSample> samples = db.findById(bloodGroup).get().getAvailableSamples();

		if (samples == null)
			return new ArrayList<BloodSampleProxy>();

		return mapper.convertListValue(samples, BloodSampleProxy.class);

	}

	@Override
	public List<TransactionProxy> getAllBloodGroupTransactions(BloodType bloodGroup) {

		if (!db.existsById(bloodGroup))
			throw new RuntimeException("No such blood group exist in bank");

		List<Transaction> transactions = db.findById(bloodGroup).get().getTransactions();
		if (transactions == null)
			return new ArrayList<TransactionProxy>();

		return mapper.convertListValue(transactions, TransactionProxy.class);

	}

	@Override
	public List<TransactionProxy> getAllBloodGroupTransactionsAsPerType(BloodType bloodGroup, TransactionType type) {
		if (!db.existsById(bloodGroup))
			throw new RuntimeException("No such blood group exist in bank");

		List<Transaction> transactions = db.findById(bloodGroup).get().getTransactions();

		if (transactions == null)
			return new ArrayList<TransactionProxy>();

		List<Transaction> requiredTransactions = transactions.stream().filter(t -> t.getType() == type)
				.collect(Collectors.toList());
		return mapper.convertListValue(requiredTransactions, TransactionProxy.class);
	}

	@Override
	public List<BloodSampleProxy> getAllBloodGroupSamplesAsPerQuality(BloodType bloodGroup, BloodQuality quality) {
		if (!db.existsById(bloodGroup))
			throw new RuntimeException("No such blood group exist in bank");

		List<BloodSample> samples = db.findById(bloodGroup).get().getAvailableSamples();

		if (samples == null)
			return new ArrayList<BloodSampleProxy>();

		List<BloodSample> requiredSamples = samples.stream().filter(s -> s.getQuality() == quality)
				.collect(Collectors.toList());

		return mapper.convertListValue(requiredSamples, BloodSampleProxy.class);
	}

	@Override
	public String addBloodGroup(BloodType newBloodGroup) {
		if (db.existsById(newBloodGroup))
			return "Blood Group Already Exists";

		BloodGroup newbg = new BloodGroup();
		newbg.setAvailableSamples(null);
		newbg.setTransactions(null);
		newbg.setType(newBloodGroup);

		db.save(newbg);

		return "New Blood Group Added To Bank Successfully";
	}

}
