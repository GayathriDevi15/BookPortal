package com.bookpartnerportal.bookpartnerportal.jobsexception;

public class MinLvlNotFoundException extends RuntimeException{
	public MinLvlNotFoundException(String message){
		super(message);
	}
	public MinLvlNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public MinLvlNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
