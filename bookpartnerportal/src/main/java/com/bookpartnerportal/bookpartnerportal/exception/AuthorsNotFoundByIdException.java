package com.bookpartnerportal.bookpartnerportal.exception;

public class AuthorsNotFoundByIdException extends RuntimeException {

	public AuthorsNotFoundByIdException(String message) {
		super(message);
	}

	public AuthorsNotFoundByIdException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorsNotFoundByIdException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
