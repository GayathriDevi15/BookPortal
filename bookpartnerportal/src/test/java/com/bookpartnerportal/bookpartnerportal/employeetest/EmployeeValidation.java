package com.bookpartnerportal.bookpartnerportal.employeetest;

public class EmployeeValidation {
	public static boolean checkLength(String endpoint) {
        String[] parts = endpoint.split("/");
        String str = parts[parts.length - 1]; 
        if(str.length()>10)
        	return false;
        return true;
}
}
