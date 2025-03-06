package com.bloodbank.service_bank.domian;

import java.util.List;

import com.bloodbank.service_bank.enums.BloodType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BloodGroup {
	
	@Id
	@Enumerated(EnumType.STRING)
	private BloodType type;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<BloodSample> availableSamples;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	
}
