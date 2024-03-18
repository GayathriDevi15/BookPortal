package com.bookpartnerportal.bookpartnerportal.jobsexception;

public class JobsUpdateValidationException  extends RuntimeException{
	public JobsUpdateValidationException(String message){
		super(message);
	}
	public JobsUpdateValidationException(String message,Throwable e){
		super(message,e);
	}
	public JobsUpdateValidationException(String message,Throwable e,boolean enablesuppression,boolean enablestacktrace){
		super(message,e,enablesuppression,enablestacktrace);
	}
}
