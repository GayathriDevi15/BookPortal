package com.bookpartnerportal.bookpartnerportal.storeexception;

public class StorIdNotFoundException extends RuntimeException {
	public StorIdNotFoundException(String message) {
		super(message);
	}

	public StorIdNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public StorIdNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace) {
		super(message, e, enablesuppression, enablestacktrace);
	}

}
