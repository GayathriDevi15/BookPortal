package com.bookpartnerportal.bookpartnerportal.storeexception;

public class StoreIdNotFoundException extends RuntimeException {
	public StoreIdNotFoundException(String message) {
		super(message);
	}

	public StoreIdNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public StoreIdNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace) {
		super(message, e, enablesuppression, enablestacktrace);
	}

}
