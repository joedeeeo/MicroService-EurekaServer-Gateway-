package com.bloodbank.service_donor.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageEnum {
	DONOR_NOT_FOUND("Donor Not found","102"),
	USERNAME_EXISTS("Username already exists.","101");
	private String errMessage;
	private String errCode;
}
