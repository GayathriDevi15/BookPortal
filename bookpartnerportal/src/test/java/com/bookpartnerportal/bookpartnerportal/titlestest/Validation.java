package com.bookpartnerportal.bookpartnerportal.titlestest;

public class Validation {
	public static boolean extractString(String endpoint) {
        String[] parts = endpoint.split("/");
        String str = parts[parts.length - 1]; 
        if(str.length()>10)
        	return false;
        return true;
    }
}
