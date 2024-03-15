package com.bookpartnerportal.bookpartnerportal.employeeexception;
 
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
 
public class ErrorResponse {
	private LocalDate timeStamp;
	  private String message;
	public ErrorResponse(LocalDate timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
	}
	public ErrorResponse() {
		super();
	}
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	}