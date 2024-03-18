package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookpartnerportal.bookpartnerportal.exception.SalesNotFoundByStoreIdException;

@ControllerAdvice
public class SalesExceptionHandler {
	// Sales details by storeId not found
	@ExceptionHandler(SalesNotFoundByStoreIdException.class)
	public ResponseEntity<ErrorResponse> handlerexception(SalesNotFoundByStoreIdException ex) {
		ErrorResponse err = new ErrorResponse();
		err.setTimeStamp(LocalDate.now());
		err.setMessage(ex.getMessage());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

}
