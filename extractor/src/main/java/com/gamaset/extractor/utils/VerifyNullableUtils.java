package com.gamaset.extractor.utils;

public class VerifyNullableUtils {

	public static double verify(Double value){
		if(value == null){
			return 0d;
		}
		
		return value;
	}
	
}
