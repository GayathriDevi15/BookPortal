package com.bookpartnerportal.bookpartnerportal.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private String msg;
	private HttpStatus status;
	private long timestamp;
	public ErrorResponse(String msg, HttpStatus status, long timestamp) {
		this.msg = msg;
		this.status = status;
		this.timestamp = timestamp;
	}
	public ErrorResponse() {
	 
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus notFound) {
		this.status = notFound;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
