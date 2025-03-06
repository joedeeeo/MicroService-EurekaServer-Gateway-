package com.bloodbank.service_bank.domian;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bloodbank.service_bank.enums.BloodQuality;
import com.bloodbank.service_bank.enums.BloodType;
import com.bloodbank.service_bank.enums.Role;
import com.bloodbank.service_bank.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uniqueId;
	
	@CreationTimestamp
	private Date date;
	
	@NotNull
	private Long transactionId;
	
	@NotBlank
	private String userName;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Min(value = 1)
	private Long units;
	
	@Enumerated(EnumType.STRING)
	private BloodQuality quality;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "blood_group")
	private BloodType group;
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	

}
