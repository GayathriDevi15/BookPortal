package com.bookpartnerportal.bookpartnerportal.exception;

public class SalesNotFoundByTitleIDException  extends RuntimeException{
	public SalesNotFoundByTitleIDException(String message){
		super(message);
	}
	public SalesNotFoundByTitleIDException(String message,Throwable e){
		super(message,e);
	}
	public SalesNotFoundByTitleIDException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
