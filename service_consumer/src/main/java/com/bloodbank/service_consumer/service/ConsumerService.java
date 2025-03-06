package com.bloodbank.service_consumer.service;

import java.util.List;

import com.bloodbank.service_consumer.domain.Transaction;
import com.bloodbank.service_consumer.proxy.ConsumerProxy;

public interface ConsumerService {
	
	public List<ConsumerProxy> getAllConsumer();
	
	public ConsumerProxy getConsumerByUsername(String username);
	
	public String deleteConsumerByUsername(String username);
	
	public ConsumerProxy saveConsumer(ConsumerProxy consumer);
	
	public Boolean isConsumerUsernameAvailable(String username);
	
	public String requestBlood(Transaction transaction);
	
	public List<String> getAllBloodGroups();
}
