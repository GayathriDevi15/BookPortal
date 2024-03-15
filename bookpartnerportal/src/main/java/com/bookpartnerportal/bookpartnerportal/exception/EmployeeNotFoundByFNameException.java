package com.bookpartnerportal.bookpartnerportal.exception;

public class EmployeeNotFoundByFNameException extends RuntimeException{
	public EmployeeNotFoundByFNameException(String message){
		super(message);
	}
	public EmployeeNotFoundByFNameException(String message,Throwable e){
		super(message,e);
	}
	public EmployeeNotFoundByFNameException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
