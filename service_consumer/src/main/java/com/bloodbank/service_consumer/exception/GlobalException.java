package com.bloodbank.service_consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(value = UsernameExistsException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public ErrorMessage handleUsernameExists(UsernameExistsException e) {
		return new ErrorMessage(e.getErrMessage(), e.getErrCode());
	}
}
