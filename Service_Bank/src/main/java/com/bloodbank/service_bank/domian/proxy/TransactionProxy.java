package com.bloodbank.service_bank.domian.proxy;

import java.sql.Date;

import com.bloodbank.service_bank.enums.BloodQuality;
import com.bloodbank.service_bank.enums.BloodType;
import com.bloodbank.service_bank.enums.Role;
import com.bloodbank.service_bank.enums.TransactionType;
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
	
	private Long uniqueId;
	
	private Role role;
	
	private Long units;
	
	private BloodQuality quality;
	
	private BloodType group;
	
	private TransactionType type;
	
	private Date date;

}
