package com.bookpartnerportal.bookpartnerportal.authorexception;

public class AuthorsNotFoundByPhoneException extends RuntimeException {

	public AuthorsNotFoundByPhoneException(String message) {
		super(message);
	}

	public AuthorsNotFoundByPhoneException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorsNotFoundByPhoneException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
