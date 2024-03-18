package com.bookpartnerportal.bookpartnerportal.jobsexception;

public class JobIdNotFoundException extends RuntimeException {
	public JobIdNotFoundException(String message) {
		super(message);
	}

	public JobIdNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public JobIdNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace) {
		super(message, e, enablesuppression, enablestacktrace);
	}
}
