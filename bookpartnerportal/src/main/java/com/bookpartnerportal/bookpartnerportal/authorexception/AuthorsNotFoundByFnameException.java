package com.bookpartnerportal.bookpartnerportal.authorexception;

public class AuthorsNotFoundByFnameException extends RuntimeException {

	public AuthorsNotFoundByFnameException(String message) {
		super(message);
	}

	public AuthorsNotFoundByFnameException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorsNotFoundByFnameException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
