package com.bookpartnerportal.bookpartnerportal.exception;

public class AuthorsNotFoundByStateException extends RuntimeException {

	public AuthorsNotFoundByStateException(String message) {
		super(message);
	}

	public AuthorsNotFoundByStateException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorsNotFoundByStateException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
