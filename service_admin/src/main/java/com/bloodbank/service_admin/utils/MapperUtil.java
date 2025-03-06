package com.bloodbank.service_admin.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MapperUtil {
	public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(fromValue, toValueType);
	}
	
	public static <T> List<T> convertListOfValue(List<?> fromValue, Class<T> toValueType) {
		List<T> listValue = new ArrayList<>();
		for (Object o : fromValue) {
			ObjectMapper mapper = new ObjectMapper();
			T convertValue = mapper.convertValue(o, toValueType);
			listValue.add(convertValue);
		}
		return listValue;
	}
}
