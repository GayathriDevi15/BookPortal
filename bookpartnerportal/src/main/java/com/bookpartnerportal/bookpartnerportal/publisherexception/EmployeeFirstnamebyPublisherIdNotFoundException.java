package com.bookpartnerportal.bookpartnerportal.publisherexception;

public class EmployeeFirstnamebyPublisherIdNotFoundException extends RuntimeException {
	public EmployeeFirstnamebyPublisherIdNotFoundException(String message){
		super(message);
	}
	public EmployeeFirstnamebyPublisherIdNotFoundException(String message, Throwable e){
		super(message,e);
	}
	public EmployeeFirstnamebyPublisherIdNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
