package com.bookpartnerportal.bookpartnerportal.storeexception;

public class ZipNotFoundException extends RuntimeException {

	public ZipNotFoundException(String message) {
		super(message);
	}

	public ZipNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public ZipNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace) {
		super(message, e, enablesuppression, enablestacktrace);
	}
}