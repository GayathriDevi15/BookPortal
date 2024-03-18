package com.bookpartnerportal.bookpartnerportal.publisherexception;

public class PublishersNotFoundException extends RuntimeException {
	public PublishersNotFoundException(String message){
		super(message);
	}
	public PublishersNotFoundException(String message, Throwable e){
		super(message,e);
	}
	public PublishersNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
