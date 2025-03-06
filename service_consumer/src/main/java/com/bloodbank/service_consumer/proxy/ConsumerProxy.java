package com.bloodbank.service_consumer.proxy;

import com.bloodbank.service_consumer.enums.Gender;
import com.bloodbank.service_consumer.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerProxy {

	private String username;
	@NotBlank
	private String name;
	@NotBlank
	private Gender gender;
	@NotNull
	private String password;
	@NotBlank
	private Role role;
	@NotNull
	private Boolean isActive;
}
