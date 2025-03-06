package com.bloodbank.service_admin.proxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AdminProxy {
	
	private Long id;
	private String name;
	
	//@Enumerated(EnumType.STRING)
	private String gender;
	@Column(unique = true)
	private String username;
	private String password;
	
	//@Enumerated(EnumType.STRING)
	private String role;
	private Boolean isActive;

}
