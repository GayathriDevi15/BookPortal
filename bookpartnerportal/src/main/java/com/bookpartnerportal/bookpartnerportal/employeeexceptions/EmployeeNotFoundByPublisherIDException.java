package com.bookpartnerportal.bookpartnerportal.employeeexceptions;

public class EmployeeNotFoundByPublisherIDException extends RuntimeException{
	public EmployeeNotFoundByPublisherIDException(String message){
		super(message);
	}
	public EmployeeNotFoundByPublisherIDException(String message,Throwable e){
		super(message,e);
	}
	public EmployeeNotFoundByPublisherIDException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
