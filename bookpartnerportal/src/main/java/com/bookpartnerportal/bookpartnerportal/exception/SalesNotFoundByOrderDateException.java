package com.bookpartnerportal.bookpartnerportal.exception;

public class SalesNotFoundByOrderDateException extends RuntimeException{
	public SalesNotFoundByOrderDateException(String message){
		super(message);
	}
	public SalesNotFoundByOrderDateException(String message,Throwable e){
		super(message,e);
	}
	public SalesNotFoundByOrderDateException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
