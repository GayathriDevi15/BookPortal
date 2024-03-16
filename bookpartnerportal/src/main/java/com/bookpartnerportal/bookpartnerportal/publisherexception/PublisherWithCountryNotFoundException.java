package com.bookpartnerportal.bookpartnerportal.publisherexception;

public class PublisherWithCountryNotFoundException extends RuntimeException {
	public PublisherWithCountryNotFoundException(String message){
		super(message);
	}
	public PublisherWithCountryNotFoundException(String message, Throwable e){
		super(message,e);
	}
	public PublisherWithCountryNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
