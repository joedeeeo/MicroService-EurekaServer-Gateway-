package com.bloodbank.service_consumer.controller;

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

import com.bloodbank.service_consumer.domain.Transaction;
import com.bloodbank.service_consumer.proxy.ConsumerProxy;
import com.bloodbank.service_consumer.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ServiceConsumerController {

	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping("/getAllConsumer")
	public List<ConsumerProxy> getAllConsumer() {
		return consumerService.getAllConsumer();
	}
	
	@GetMapping("/getConsumerByUsername/{username}")
	public ConsumerProxy getConsumerByUsername(@PathVariable("username") String username) {
		return consumerService.getConsumerByUsername(username);
	}
	
	@DeleteMapping("/deleteConsumerByUsername/{username}")
	public String deleteConsumerByUsername(@PathVariable("username") String username) {
		return consumerService.deleteConsumerByUsername(username);
	}
	
	@PostMapping("/saveConsumer")
	public ConsumerProxy saveConsumer(@RequestBody ConsumerProxy consumer) {
		return consumerService.saveConsumer(consumer);
	}
	
	@PostMapping("/requestBlood")
	public String requestBlood(@RequestBody Transaction transaction) {
		 transaction.setTransactionId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
		return consumerService.requestBlood(transaction);
	}
	
	@GetMapping("/getAllBloodGroups")
	public List<String>getAllBloodGroups(){
		return consumerService.getAllBloodGroups();
	}
	
	@GetMapping("/isConsumerUsernameAvailable/{username}")
	public Boolean isConsumerUsernameAvailable(@PathVariable String username) {
		return consumerService.isConsumerUsernameAvailable(username);
	}
}
