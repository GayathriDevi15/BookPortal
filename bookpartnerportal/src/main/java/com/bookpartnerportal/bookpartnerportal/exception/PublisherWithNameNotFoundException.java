package com.bookpartnerportal.bookpartnerportal.exception;

public class PublisherWithNameNotFoundException extends RuntimeException {
	public PublisherWithNameNotFoundException(String message){
		super(message);
	}
	public PublisherWithNameNotFoundException(String message, Throwable e){
		super(message,e);
	}
	public PublisherWithNameNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
