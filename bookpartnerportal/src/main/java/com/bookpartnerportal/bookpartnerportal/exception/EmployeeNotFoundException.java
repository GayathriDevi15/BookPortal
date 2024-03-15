package com.bookpartnerportal.bookpartnerportal.exception;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String message){
		super(message);
	}
	public EmployeeNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public EmployeeNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
