package com.bookpartnerportal.bookpartnerportal.authorexception;

public class AuthorsNotFoundByCityException extends RuntimeException {

	public AuthorsNotFoundByCityException(String message) {
		super(message);
	}

	public AuthorsNotFoundByCityException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorsNotFoundByCityException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
