package com.bookpartnerportal.bookpartnerportal.publishertest;


//testing with publisherIdSize
public class PublisherValidation {
	public static boolean extractString(String endpoint) {
        String[] parts = endpoint.split("/");
        String str = parts[parts.length - 1]; 
        if(str.length()!=4)
        	return false;
        return true;
    }
}
