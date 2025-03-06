package com.bloodbank.service_donor.domain;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.bloodbank.service_donor.enums.BloodType;
import com.bloodbank.service_donor.enums.Gender;
import com.bloodbank.service_donor.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Donor {
	
	@Id
	private String username;
	
	private String password;
	
	private String fullName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = "blood_group")
	@Enumerated(EnumType.STRING)
	private BloodType group;
	
	private Boolean isActive;
}	
