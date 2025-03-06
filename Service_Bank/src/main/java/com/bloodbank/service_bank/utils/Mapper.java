package com.bloodbank.service_bank.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Mapper {
	
	@Autowired
	private ObjectMapper objMapper;
	
	public <T> T convertValue(Object fromValue,Class<T> toValueType) {
		
		return objMapper.convertValue(fromValue, toValueType);
	}
	
	public <T> List<T> convertListValue(List<?> fromValue, Class<T> toValueType) {
		
	    List<T> listValue = new ArrayList<>();
	    for (Object o : fromValue) {
	        T convertValue = objMapper.convertValue(o, toValueType);
	        listValue.add(convertValue);
	    }
	    return listValue;
	}
	
	

}
