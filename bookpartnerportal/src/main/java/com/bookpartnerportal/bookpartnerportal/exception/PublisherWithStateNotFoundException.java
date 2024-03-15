package com.bookpartnerportal.bookpartnerportal.exception;

public class PublisherWithStateNotFoundException extends RuntimeException {
	public PublisherWithStateNotFoundException(String message){
		super(message);
	}
	public PublisherWithStateNotFoundException(String message, Throwable e){
		super(message,e);
	}
	public PublisherWithStateNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
