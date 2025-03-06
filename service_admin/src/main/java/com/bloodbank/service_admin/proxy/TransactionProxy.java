package com.bloodbank.service_admin.proxy;

import com.bloodbank.service_admin.enums.BloodQuality;
import com.bloodbank.service_admin.enums.BloodType;
import com.bloodbank.service_admin.enums.Role;
import com.bloodbank.service_admin.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class TransactionProxy {
	
	private Long transactionId;
	private String userName;
	
	private Role role;
	private Long units;
	
	private BloodQuality quality;
	
	private BloodType group;
	
	private TransactionType type;
}
