package com.bookpartnerportal.bookpartnerportal.exception;

public class EmployeeNotFoundByLNameException extends RuntimeException{
	public EmployeeNotFoundByLNameException(String message){
		super(message);
	}
	public EmployeeNotFoundByLNameException(String message,Throwable e){
		super(message,e);
	}
	public EmployeeNotFoundByLNameException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
