package com.bookpartnerportal.bookpartnerportal.storeexception;

public class StoresUpdateValidationException extends RuntimeException{
	public StoresUpdateValidationException(String message){
		super(message);
	}
	public StoresUpdateValidationException(String message,Throwable e){
		super(message,e);
	}
	public StoresUpdateValidationException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
