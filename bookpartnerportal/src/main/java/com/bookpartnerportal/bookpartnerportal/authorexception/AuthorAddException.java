package com.bookpartnerportal.bookpartnerportal.authorexception;

public class AuthorAddException extends RuntimeException {

	public AuthorAddException(String message) {
		super(message);
	}

	public AuthorAddException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorAddException(String message, Throwable e, boolean enablesupression, boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
