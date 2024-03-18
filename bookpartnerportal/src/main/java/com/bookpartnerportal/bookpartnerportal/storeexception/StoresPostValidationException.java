package com.bookpartnerportal.bookpartnerportal.storeexception;

public class StoresPostValidationException  extends RuntimeException{
	public StoresPostValidationException(String message){
		super(message);
	}
	public StoresPostValidationException(String message,Throwable e){
		super(message,e);
	}
	public StoresPostValidationException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
