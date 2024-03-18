package com.bookpartnerportal.bookpartnerportal.exception;

public class AuthorsNotFoundByZipException extends RuntimeException {

	public AuthorsNotFoundByZipException(String message) {
		super(message);
	}

	public AuthorsNotFoundByZipException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorsNotFoundByZipException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
