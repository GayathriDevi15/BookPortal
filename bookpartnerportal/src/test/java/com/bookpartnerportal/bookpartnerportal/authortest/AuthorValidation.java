package com.bookpartnerportal.bookpartnerportal.authortest;
public class AuthorValidation {
	public static boolean au_idlength(String endpoint) {
        String[] parts = endpoint.split("/");
        String str = parts[parts.length - 1]; 
        if(str.length()>11)
        	return false;
        return true;
    }
}