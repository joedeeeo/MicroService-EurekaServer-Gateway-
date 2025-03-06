package com.bloodbank.service_consumer.domain;

import com.bloodbank.service_consumer.enums.BloodQuality;
import com.bloodbank.service_consumer.enums.BloodType;
import com.bloodbank.service_consumer.enums.Role;
import com.bloodbank.service_consumer.enums.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	
	private Long transactionId;
	private String userName;
	@Enumerated(EnumType.STRING)
	private Role role;
	private Long units;
	@Enumerated(EnumType.STRING)
	private BloodQuality quality;
	@Enumerated(EnumType.STRING)
	private BloodType group;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
}
