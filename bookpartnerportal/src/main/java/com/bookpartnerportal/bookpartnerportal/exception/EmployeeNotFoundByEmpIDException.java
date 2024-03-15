package com.bookpartnerportal.bookpartnerportal.exception;

public class EmployeeNotFoundByEmpIDException extends RuntimeException{
	public EmployeeNotFoundByEmpIDException(String message){
		super(message);
	}
	public EmployeeNotFoundByEmpIDException(String message,Throwable e){
		super(message,e);
	}
	public EmployeeNotFoundByEmpIDException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
