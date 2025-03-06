package com.bloodbank.service_bank.domian;

import com.bloodbank.service_bank.enums.BloodQuality;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BloodSample {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sampleId;
	
	private Long uniqueTransactionId;
	
	private String donerName;
	
	private Long unitsAvailable;
	
	@Enumerated(EnumType.STRING)
	private BloodQuality quality;
	
}
