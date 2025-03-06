package com.bloodbank.service_consumer.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MapperUtils {
	public static <T> T convertValue(Object fromValue,Class<T> toValueType) {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.convertValue(fromValue, toValueType);
	}
	
	public static <T> List<T> convertListValue(List<?> fromValue, Class<T> toValueType) {
	    List<T> listValue = new ArrayList<>();
	    ObjectMapper objMapper = new ObjectMapper(); // Move ObjectMapper outside the loop for efficiency
	    for (Object o : fromValue) {
	        T convertValue = objMapper.convertValue(o, toValueType);
	        listValue.add(convertValue);
	    }
	    return listValue;
	}
 
}
 