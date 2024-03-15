package com.bookpartnerportal.bookpartnerportal.exceptionhandler;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookpartnerportal.bookpartnerportal.salesexceptions.SalesDetailsNotFoundException;
import com.bookpartnerportal.bookpartnerportal.salesexceptions.SaleswithOrdnumNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.ValidationException;

@ControllerAdvice
public class SalesExceptionHandler {
	
	@ExceptionHandler
	  public ResponseEntity<ErrorResponse> handleException(SalesDetailsNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
			
	  }
	
	@ExceptionHandler
	  public ResponseEntity<ErrorResponse> handleException(SaleswithOrdnumNotFoundException exe){
			ErrorResponse err=new ErrorResponse();
			err.setTimeStamp(LocalDate.now());
			err.setMessage(exe.getMessage());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
			
	   }
	
}
