package com.bookpartnerportal.bookpartnerportal.storeexception;

public class StoresNotFoundException extends RuntimeException{
	public StoresNotFoundException(String message){
		super(message);
	}
	public StoresNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public  StoresNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
