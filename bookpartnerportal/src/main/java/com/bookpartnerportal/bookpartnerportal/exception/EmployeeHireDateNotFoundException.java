package com.bookpartnerportal.bookpartnerportal.exception;

public class EmployeeHireDateNotFoundException extends RuntimeException{
	public EmployeeHireDateNotFoundException(String message){
		super(message);
	}
	public EmployeeHireDateNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public EmployeeHireDateNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
