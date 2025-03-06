package com.bloodbank.service_consumer.domain;

import com.bloodbank.service_consumer.enums.Gender;
import com.bloodbank.service_consumer.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_consumer")
public class Consumer {

	@Id
	private String username;
	private String name;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	private Boolean isActive;
}
