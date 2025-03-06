package com.bloodbank.service_donor.domain;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bloodbank.service_donor.enums.BloodQuality;
import com.bloodbank.service_donor.enums.BloodType;
import com.bloodbank.service_donor.enums.Role;
import com.bloodbank.service_donor.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;  //uniquely generate this id
	
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
