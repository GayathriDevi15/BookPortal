package com.bookpartnerportal.bookpartnerportal.storeexception;

public class CityNotFoundException extends RuntimeException {
	public CityNotFoundException(String message){
		super(message);
	}
	public CityNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public CityNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
	

}
