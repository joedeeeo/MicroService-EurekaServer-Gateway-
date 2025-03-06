package com.bloodbank.service_admin.proxy;

import org.hibernate.validator.constraints.Range;

import com.bloodbank.service_admin.enums.BloodQuality;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class BloodSampleProxy {
	
	private Long sampleId;
	@NotBlank
	private Long uniqueTransactionId;
	@NotBlank
	private String userName;
	
	@Range(min = 1)
	private Long unitsAvailable;
 
	private BloodQuality quality;
}
