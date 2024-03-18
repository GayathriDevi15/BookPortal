package com.bookpartnerportal.bookpartnerportal.publisherexception;

public class EmployeesbyPublisherIdNotFoundException extends RuntimeException {
	public EmployeesbyPublisherIdNotFoundException(String message){
		super(message);
	}
	public EmployeesbyPublisherIdNotFoundException(String message, Throwable e){
		super(message,e);
	}
	public EmployeesbyPublisherIdNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
