package com.bloodbank.service_consumer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageEnum {

	CONSUMER_NOT_FOUND("Consumer Not found ","222"),
	USERNAME_EXISTS("Username already exists ","111");
	private String errMessage;
	private String errCode;
}
