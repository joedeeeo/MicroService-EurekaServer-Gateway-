package com.bloodbank.service_donor.proxy;

import java.sql.Date;

import com.bloodbank.service_donor.enums.BloodType;
import com.bloodbank.service_donor.enums.Gender;
import com.bloodbank.service_donor.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorProxy {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String fullName;
	@NotNull
	private Gender gender;
	@NotNull
	private Role role;
	@NotNull
	private BloodType group;
	@NotNull
	private Boolean isActive;
}
