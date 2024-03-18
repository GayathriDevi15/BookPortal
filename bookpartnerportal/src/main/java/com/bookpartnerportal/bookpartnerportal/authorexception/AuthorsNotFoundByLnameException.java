package com.bookpartnerportal.bookpartnerportal.authorexception;

public class AuthorsNotFoundByLnameException extends RuntimeException {

	public AuthorsNotFoundByLnameException(String message) {
		super(message);
	}

	public AuthorsNotFoundByLnameException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorsNotFoundByLnameException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
