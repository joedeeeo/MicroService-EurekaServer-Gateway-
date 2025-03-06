package com.bloodbank.service_donor.exceptions;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Component
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorMessage {   
	private String errorMessage;
	private String errorCode;
}

