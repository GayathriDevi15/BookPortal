package com.bookpartnerportal.bookpartnerportal.exception;

public class PublisherWithIdNotFoundException extends RuntimeException {
	public PublisherWithIdNotFoundException(String message){
		super(message);
	}
	public PublisherWithIdNotFoundException(String message, Throwable e){
		super(message,e);
	}
	public PublisherWithIdNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
