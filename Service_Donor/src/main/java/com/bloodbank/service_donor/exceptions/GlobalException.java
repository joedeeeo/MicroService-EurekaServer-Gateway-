package com.bloodbank.service_donor.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = DonorNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage handleDonorNotFound(DonorNotFoundException e) {
		return new ErrorMessage(e.getErrorMessage(), e.getErrorCode());

	}
	
	@ExceptionHandler(value = UsernameExistsException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public ErrorMessage handleUsernameExists(UsernameExistsException e) {
		return new ErrorMessage(e.getErrorMessage(), e.getErrorCode());

	}
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public ErrorMessage handleObjectEmpty(HttpMessageNotReadableException e) {
		return new ErrorMessage("Object cannot be empty.", HttpStatus.NOT_ACCEPTABLE.toString());

	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Map<String,String> handleAttributes(MethodArgumentNotValidException e) {
		Map<String,String> errList = new HashMap<>();
		e.getAllErrors().forEach(ex -> {
			String fieldName = ((FieldError) ex).getField();
			String value = ex.getDefaultMessage();
			errList.put(fieldName, value);
		});
		return errList;
	}
}
