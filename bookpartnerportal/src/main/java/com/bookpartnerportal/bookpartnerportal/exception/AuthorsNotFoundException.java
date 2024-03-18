package com.bookpartnerportal.bookpartnerportal.exception;

public class AuthorsNotFoundException extends RuntimeException {

	public AuthorsNotFoundException(String message) {
		super(message);
	}

	public AuthorsNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorsNotFoundException(String message, Throwable e, boolean enablesupression, boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}
}
