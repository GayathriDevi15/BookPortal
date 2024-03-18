package com.bookpartnerportal.bookpartnerportal.exception;

public class SalesNotFoundByStoreIdException extends RuntimeException {

	public SalesNotFoundByStoreIdException(String message) {
		super(message);
	}

	public SalesNotFoundByStoreIdException(String message, Throwable e) {
		super(message, e);
	}

	public SalesNotFoundByStoreIdException(String message, Throwable e, boolean enablesupression,
			boolean enablestacktrace) {
		super(message, e, enablesupression, enablestacktrace);
	}

}
