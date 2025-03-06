package com.bloodbank.service_admin.domain;

import com.bloodbank.service_admin.enums.Gender;
import com.bloodbank.service_admin.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin_tbl")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	//@Enumerated(EnumType.STRING)
	private String gender;
	private String username;
	private String password;
	
	//@Enumerated(EnumType.STRING)
	private String role;
	private Boolean isActive;
}
