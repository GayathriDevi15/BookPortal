package com.bookpartnerportal.bookpartnerportal.authorexception;

public class AuthorUpdateException extends RuntimeException {

	public AuthorUpdateException(String message) {
		super(message);
	}

	public AuthorUpdateException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorUpdateException(String message, Throwable e, boolean enablesupression, boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
