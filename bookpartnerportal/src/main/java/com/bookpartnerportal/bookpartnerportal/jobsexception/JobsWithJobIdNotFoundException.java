package com.bookpartnerportal.bookpartnerportal.jobsexception;

public class JobsWithJobIdNotFoundException extends RuntimeException {
	public JobsWithJobIdNotFoundException(String message) {
		super(message);
	}

	public JobsWithJobIdNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public JobsWithJobIdNotFoundException(String message, Throwable e, boolean enablesuppression,
			boolean enablestacktrace) {
		super(message, e, enablesuppression, enablestacktrace);
	}
}
