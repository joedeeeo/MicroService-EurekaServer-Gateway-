package com.bloodbank.service_consumer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.service_consumer.domain.Consumer;
import com.bloodbank.service_consumer.proxy.ConsumerProxy;

@Repository
public interface ConsumerRepo extends JpaRepository<Consumer, String>{

//	Optional<ConsumerProxy> findByUsername(String username);

//	Optional<ConsumerProxy> deleteConsumerByUsername(String username);

}
