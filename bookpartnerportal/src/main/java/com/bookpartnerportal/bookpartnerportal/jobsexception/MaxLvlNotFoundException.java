
package com.bookpartnerportal.bookpartnerportal.jobsexception;

public class MaxLvlNotFoundException extends RuntimeException {
	public MaxLvlNotFoundException(String message) {
		super(message);
	}

	public MaxLvlNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public MaxLvlNotFoundException(String message, Throwable e, boolean enablesuppression, boolean enablestacktrace) {
		super(message, e, enablesuppression, enablestacktrace);
	}
}
