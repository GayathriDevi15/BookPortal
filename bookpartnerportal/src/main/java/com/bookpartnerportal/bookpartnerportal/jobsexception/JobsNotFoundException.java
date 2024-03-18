package com.bookpartnerportal.bookpartnerportal.jobsexception;

public class JobsNotFoundException extends RuntimeException {
	public JobsNotFoundException(String message){
		super(message);
	}
	public JobsNotFoundException(String message,Throwable e){
		super(message,e);
	}
	public JobsNotFoundException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
