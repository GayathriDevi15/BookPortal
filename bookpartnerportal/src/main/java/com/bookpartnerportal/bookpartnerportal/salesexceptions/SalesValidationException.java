package com.bookpartnerportal.bookpartnerportal.salesexceptions;

public class SalesValidationException extends RuntimeException{
	public SalesValidationException(String message){
		super(message);
	}
	public SalesValidationException(String message,Throwable e){
		super(message,e);
	}
	public SalesValidationException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
