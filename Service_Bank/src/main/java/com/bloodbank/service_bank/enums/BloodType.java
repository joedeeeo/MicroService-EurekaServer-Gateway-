package com.bloodbank.service_bank.enums;



public enum BloodType {
	AP("A+"),
	AN("A-"),
	BP("B+"),
	BN("B-"),
	OP("O+"),
	ON("O-"),
	ABP("AB+"),
	ABN("AB-");
	
	private String name;

	BloodType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
