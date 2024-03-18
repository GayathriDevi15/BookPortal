package com.bookpartnerportal.bookpartnerportal.success;

import java.time.LocalDate;
import java.util.Date;

public class CustomResponse {
	private LocalDate TimeStamp;
	private String message;

	public LocalDate getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		TimeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomResponse(LocalDate timeStamp, String message) {
		super();
		TimeStamp = timeStamp;
		this.message = message;
	}

	public CustomResponse() {
		super();
	}

}
