package com.bookpartnerportal.bookpartnerportal.authorexception;

public class AuthorDeleteException extends RuntimeException {

	public AuthorDeleteException(String message) {
		super(message);
	}

	public AuthorDeleteException(String message, Throwable e) {
		super(message, e);
	}

	public AuthorDeleteException(String message, Throwable e, boolean enablesupression, boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
