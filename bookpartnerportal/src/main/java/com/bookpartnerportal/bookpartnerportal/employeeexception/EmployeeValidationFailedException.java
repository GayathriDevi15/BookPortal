package com.bookpartnerportal.bookpartnerportal.employeeexception;

public class EmployeeValidationFailedException extends RuntimeException{
	public EmployeeValidationFailedException(String message){
		super(message);
	}
	public EmployeeValidationFailedException(String message,Throwable e){
		super(message,e);
	}
	public EmployeeValidationFailedException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
