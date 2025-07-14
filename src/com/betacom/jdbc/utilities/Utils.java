package com.betacom.jdbc.utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static LocalDate dateToLocalDate(Object value) {
	    if (value == null) return null;

	    if (value instanceof java.sql.Date) {
	        return ((java.sql.Date) value).toLocalDate();
	    } else if (value instanceof java.util.Date) {
	        return ((java.util.Date) value).toInstant()
	                                       .atZone(ZoneId.systemDefault())
	                                       .toLocalDate();
	    } else if (value instanceof String) {
	        return LocalDate.parse((String) value); // assume formato yyyy-MM-dd
	    } else {
	        System.err.println("Tipo non gestito: " + value.getClass());
	        return null;
	    }
			
	} 
	/*
	 * Build parameters map for SQLManager
	 * key = Object position
	 * value = parameter value
	 */
//	public static Map<Integer, Object> buildParameters(Object[] p){
//		Map<Integer, Object> params = new HashMap<Integer, Object>();
//		int pIdx = 1;
//		for (Object o:p) {
//			params.put(pIdx++, o);
//		}
//		return params;
//	}
}
