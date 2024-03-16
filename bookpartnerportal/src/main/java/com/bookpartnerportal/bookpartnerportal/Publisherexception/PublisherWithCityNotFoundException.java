package com.bookpartnerportal.bookpartnerportal.publisherexception;

public class PublisherWithCityNotFoundException extends RuntimeException {
	public PublisherWithCityNotFoundException(String message){
		super(message);
	}
	public PublisherWithCityNotFoundException(String message, Throwable e){
		super(message,e);
	}
	public PublisherWithCityNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
