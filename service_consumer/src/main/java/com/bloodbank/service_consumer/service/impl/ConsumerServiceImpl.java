package com.bloodbank.service_consumer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bloodbank.service_consumer.domain.Consumer;
import com.bloodbank.service_consumer.domain.Transaction;
import com.bloodbank.service_consumer.enums.ErrorMessageEnum;
import com.bloodbank.service_consumer.exception.UsernameExistsException;
import com.bloodbank.service_consumer.proxy.ConsumerProxy;
import com.bloodbank.service_consumer.repository.ConsumerRepo;
import com.bloodbank.service_consumer.service.ConsumerService;
import com.bloodbank.service_consumer.utils.MapperUtils;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	private ConsumerRepo consumerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
//	@Autowired
//	private MapperUtils mapperUtils;

	@Override
	public List<ConsumerProxy> getAllConsumer() {
		// TODO Auto-generated method stub
		return MapperUtils.convertListValue(consumerRepo.findAll(), ConsumerProxy.class);
	}

	@Override
	public ConsumerProxy getConsumerByUsername(String username) {
		// TODO Auto-generated method stub
		Optional<Consumer> byUsername = consumerRepo.findById(username);
		if(byUsername.isPresent()) {
			ConsumerProxy convertValue = MapperUtils.convertValue(byUsername.get(), ConsumerProxy.class);
			return convertValue;
		}
		else {
			throw new RuntimeException("Consumer not found");
		}
	}

	@Override
	public String deleteConsumerByUsername(String username) {
		// TODO Auto-generated method stub
		if(consumerRepo.existsById(username)) {
			consumerRepo.deleteById(username);
			return "Consumer delete successfully";
		}
		return "Consumer not found by this name";
		
	}

	@Override
	public ConsumerProxy saveConsumer(ConsumerProxy consumer) {
	    // Corrected URL with protocol and path
	    if (!restTemplate.getForObject("http://localhost:8080/bank/is-user-name-available/" + consumer.getUsername(), Boolean.class)) {
	        throw new UsernameExistsException(ErrorMessageEnum.USERNAME_EXISTS.getErrMessage(), ErrorMessageEnum.USERNAME_EXISTS.getErrCode());
	    } else {
	        // Convert and save consumer
	        Consumer con = MapperUtils.convertValue(consumer, Consumer.class);
	        consumerRepo.save(con);
	    }
	    return null;
	}

	@Override
	public Boolean isConsumerUsernameAvailable(String username) {
		// TODO Auto-generated method stub
		return !consumerRepo.existsById(username);
	}

	@Override
	public String requestBlood(Transaction transaction) {
		// TODO Auto-generated method stub
//		return restTemplate.postForObject("http://localhost:8080/bank/request-blood", transaction, String.class);
		try {
		    return restTemplate.postForObject("http://localhost:8080/bank/request-blood", transaction, String.class);
		} catch (Exception e) {
		    e.printStackTrace();
		    return "An error occurred while processing the blood request.";
		}


	}

	@Override
	public List<String> getAllBloodGroups() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://localhost:8080/bank/get-all-blood-groups", List.class);
	}

}
