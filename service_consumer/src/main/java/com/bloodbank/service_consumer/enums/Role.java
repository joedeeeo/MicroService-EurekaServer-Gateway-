package com.bloodbank.service_consumer.enums;

public enum Role {
	ADMIN,DONOR,CONSUMER;
	
	private String role;
	
//	private Role(String role) {
//		// TODO Auto-generated constructor stub
//		this.role=role;
//	}
	
	public String getRole() {
		return role;
	}
}